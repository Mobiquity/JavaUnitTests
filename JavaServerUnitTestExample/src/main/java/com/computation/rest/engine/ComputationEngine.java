package com.computation.rest.engine;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.computation.rest.exception.mapper.ResultNotFoundException;
import com.wolfram.alpha.WAEngine;
import com.wolfram.alpha.WAException;
import com.wolfram.alpha.WAPlainText;
import com.wolfram.alpha.WAPod;
import com.wolfram.alpha.WAQuery;
import com.wolfram.alpha.WAQueryResult;
import com.wolfram.alpha.WASubpod;


public class ComputationEngine {

    private WAEngine engine;

    private WAQuery query;

    private static final String RESULT_STRING = "Result";
    
    private static final String UNIT_CONVERSION_TOTAL = "Total";

    private static final Logger LOG = LoggerFactory.getLogger(ComputationEngine.class);

    public ComputationEngine(String appId, String format) {
        engine = new WAEngine();
        engine.setAppID(appId);
        engine.addFormat(format);
    }

    public WAQuery getQuery(String input) {
        WAQuery query = engine.createQuery();
        query.setInput(input);
        return query;
    }

    public String computeOperation(String input) {
        query = getQuery(input);
        try {
            WAQueryResult queryResult = engine.performQuery(query);

            if (queryResult.isError()) {
                throw new ResultNotFoundException(queryResult.getErrorMessage());
            } else if (!queryResult.isSuccess()) {
            } else {
                for (WAPod pod : queryResult.getPods()) {
                    if (!pod.isError() && RESULT_STRING.equals(pod.getTitle())) {
                        for (WASubpod subpod : pod.getSubpods()) {
                            for (Object element : subpod.getContents()) {
                                if (element instanceof WAPlainText) {
                                    return ((WAPlainText) element).getText();
                                }
                            }
                        }
                    }
                }
            }
        } catch (WAException exc) {
            LOG.info("Exception occured in computeOperation() method ", exc);
        }
        throw new ResultNotFoundException("No result was found for input: " + input);
    }
    
    public String computeUnitConversion(String input) {
        query = getQuery(input);
        try {
            WAQueryResult queryResult = engine.performQuery(query);

            if (queryResult.isError()) {
                throw new ResultNotFoundException(queryResult.getErrorMessage());
            } else if (!queryResult.isSuccess()) {
            } else {
            	StringBuilder output = new StringBuilder();
            	
                for (WAPod pod : queryResult.getPods()) {
                    if (!pod.isError() && UNIT_CONVERSION_TOTAL.equals(pod.getTitle())) {
                        for (WASubpod subpod : pod.getSubpods()) {
                            for (Object element : subpod.getContents()) {
                                if (element instanceof WAPlainText) {
                                    output.append(((WAPlainText) element).getText()).append(", ");
                                }
                            }
                        }
                    }
                    else if (!pod.isError() && RESULT_STRING.equals(pod.getTitle())) {
                        for (WASubpod subpod : pod.getSubpods()) {
                            for (Object element : subpod.getContents()) {
                                if (element instanceof WAPlainText) {
                                    return ((WAPlainText) element).getText();
                                }
                            }
                        }
                    }
                }
                
                if(output.length() > 2) {
                	return output.substring(0, output.length()-2);
                }
            }
        } catch (WAException exc) {
            LOG.info("Exception occured in computeUnitConversion() method ", exc);
        }
        throw new ResultNotFoundException("No result was found for input: " + input);
    }

    public Double computeRadian(Double value) {
        throw new UnsupportedOperationException();
    }
}
