package com.junit.mockito.rest.endpoint.test;


public class FastJerseyTest {

//	private static DefaultResourceConfig resourceConfig = new DefaultResourceConfig();
//
//	private static TestContainerFactory testContainerFactory;
//
//	private static TestContainer testContainer;
//
//	private static Client client;
//
//	public static void addClass(Class<?> resourceClass) {
//		resourceConfig.getClasses().add(resourceClass);
//	}
//
//	public static void addSingleton(Object resourceSingleton) {
//		resourceConfig.getSingletons().add(resourceSingleton);
//	}
//
//	public static <T> void addProviderForContext(Class<T> contextClass,
//			T contextObject) {
//		addSingleton(new SingletonTypeInjectableProvider<Context, T>(
//				contextClass, contextObject) {
//		});
//	}
//
//	public static void addRequestFilter(Object filter) {
//		resourceConfig.getContainerRequestFilters().add(filter);
//	}
//
//	public static void addResponseFilter(Object filter) {
//		resourceConfig.getContainerResponseFilters().add(filter);
//	}
//
//	public static void setTestContainerFactory(
//			TestContainerFactory newTestContainerFactory) {
//		testContainerFactory = newTestContainerFactory;
//	}
//
//	@BeforeClass
//	public static void cleanStaticVariables() {
//		resourceConfig = new DefaultResourceConfig();
//	}
//
//	public static void initServer() {
//		AppDescriptor ad = new LowLevelAppDescriptor.Builder(resourceConfig)
//				.build();
//		TestContainerFactory tcf = testContainerFactory;
//		if (tcf == null) {
//			tcf = new FilteringInMemoryTestContainerFactory();
//		}
//		
//		testContainer = tcf.create(UriBuilder.fromUri("http://localhost/")
//				.port(9998).build(), ad);
//		client = testContainer.getClient();
//		if (client == null) {
//			client = Client.create(ad.getClientConfig());
//		}
//	}
//
//	public static void startServer() {
//		if (testContainer != null) {
//			testContainer.start();
//		}
//	}
//
//	@AfterClass
//	public static void stopServer() {
//		testContainer.stop();
//		testContainer = null;
//		client = null;
//	}
//
//	public Client client() {
//		return client;
//	}
//
//	public URI getBaseUri() {
//		return testContainer.getBaseUri();
//	}
//
//	public WebResource resource() {
//		return client.resource(getBaseUri());
//	}
//
//	@Before
//	public void startServerBeforeFirstTestRun() {
//		if (testContainer == null) {
//			initServer();
//			startServer();
//		}
//	}

}
