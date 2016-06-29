package com.junit.mockito.rest.endpoint.test;


public class FastTodoResourceTest extends FastJerseyTest {

//	public static ComputationService todoServiceMock = Mockito.mock(ComputationServiceImpl.class);
//
//	@BeforeClass
//	public static void configure() {
//		//addClass(TodoResource.class);
//		addProviderForContext(ComputationService.class, todoServiceMock);
//		setTestContainerFactory(new FilteringInMemoryTestContainerFactory());
//	}
//
//	@Before
//	public void resetMocks() {
//		// the mock is stored in a static field and must be reset manually
//		// before each test
//		Mockito.reset(todoServiceMock);
//	}

//	@Test(expected = TodoNotFoundException.class)
//	public void removeTodoShouldThrowNotFoundException() {
//		final String todo = "test-todo";
//		Mockito.doThrow(new TodoNotFoundException()).when(todoServiceMock)
//				.removeTodo(todo);
//		todoClient().removeTodo(todo);
//	}
//
//	@Test
//	public void shouldReturn400OnNotFoundException() {
//		String todo = "test-todo";
//		Mockito.doThrow(new TodoNotFoundException()).when(todoServiceMock)
//				.removeTodo(todo);
//		ClientResponse response = resource().path("todo/" + todo).delete(
//				ClientResponse.class);
//		Assert.assertEquals(Status.BAD_REQUEST,
//				response.getClientResponseStatus());
//		Assert.assertEquals("TodoNotFoundException",
//				response.getEntity(String.class));
//	}
//
//	private TodoClient todoClient() {
//		TodoClient todoClient = new TodoClient(getBaseUri().toString());
//		Whitebox.setInternalState(todoClient, "client", client());
//		return todoClient;
//	}
//
//	@Provider
//	public static class MockComputationServiceProvider extends
//			SingletonTypeInjectableProvider<Context, ComputationService> {
//
//		public MockComputationServiceProvider() {
//			super(ComputationService.class, todoServiceMock);
//		}
//	}
}
