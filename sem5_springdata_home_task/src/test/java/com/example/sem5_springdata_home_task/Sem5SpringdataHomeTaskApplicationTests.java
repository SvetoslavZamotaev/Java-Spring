package com.example.sem5_springdata_home_task;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Sem5SpringdataHomeTaskApplicationTests {

	@Test
	void contextLoads() {
	}


	//@RunWith(SpringRunner.class)
	//@SpringBootTest
	//@AutoConfigureMockMvc
	//public class TaskControllerTest {
	//	@Autowired
	//	private MockMvc mockMvc;

	//	@Autowired
	//	private TaskRepository taskRepository;

	//	@Test
	//	public void testAddTask() throws Exception {
	//		Task task = new Task();
	//		task.setDescription("Test task");

	//		mockMvc.perform(post("/tasks")
	//						.content(asJsonString(task))
	//						.contentType(MediaType.APPLICATION_JSON)
	//				)
	//				.andExpect(status().isOk())
	//				.andExpect(jsonPath("$.id").isNumber())
	//				.andExpect(jsonPath("$.description").value(task.getDescription()))
	//				.andExpect(jsonPath("$.status").value(TaskStatus.NOT_STARTED.toString()));
	//	}

	//	@Test
	//	public void testGetAllTasks() throws Exception {
	//		Task task1 = new Task();
	//		task1.setDescription("Task 1");

	//		Task task2 = new Task();
	//		task2.setDescription("Task 2");

	//		taskRepository.save(task1);
	//		taskRepository.save(task2);

	//		mockMvc.perform(get("/tasks"))
	//				.andExpect(status().isOk())
	//				.andExpect(jsonPath("$.[*].id").isNotEmpty())
	//				.andExpect(jsonPath("$.[*].description").value(hasItem(task1.getDescription())))
	//				.andExpect(jsonPath("$.[*].description").value(hasItem(task2.getDescription())))
	//				.andExpect(jsonPath("$.[*].status").value(hasItems(TaskStatus.NOT_STARTED.toString())));
	//	}

	//	@Test
	//	public void testGetTasksByStatus() throws Exception {
	//		Task task1 = new Task();
	//		task1.setDescription("Task 1");
	//		task1.setStatus(TaskStatus.NOT_STARTED);

	//		Task task2 = new Task();
	//		task2.setDescription("Task 2");
	//		task2.setStatus(TaskStatus.IN_PROGRESS);

	//		taskRepository.save




}
