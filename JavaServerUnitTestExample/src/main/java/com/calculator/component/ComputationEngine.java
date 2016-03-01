package com.calculator.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.calculator.component.exception.ResultNotFoundException;
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

    private static final Log LOG = LogFactory.getLog(ComputationEngine.class);

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
        } catch (WAException e) {
            LOG.info("Exception occured in computeOperation() method " + e);
        }
        throw new ResultNotFoundException("No result was found.");
    }
}
