package com.test.checkListner.controller;

import com.test.checkListner.entity.TableData;
import com.test.checkListner.repository.RepoClass;
import com.test.checkListner.service.TableService;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class NotificationController {


@Autowired
private RepoClass yourTableRepository;

@Autowired
private SimpMessagingTemplate messagingTemplate;
@Autowired
private TableService insertData;

private Timestamp lastCheckedTime = new Timestamp(System.currentTimeMillis());
int number = 0;
@Scheduled(fixedRate = 1000) // Poll every second
public void checkForUpdates() {
//	List<TableData> newRecords = yourTableRepository.findNewRecords(lastCheckedTime);
//	if (!newRecords.isEmpty()) {
//		newRecords.forEach(record -> {
//			messagingTemplate.convertAndSend("/topic/updates", record);
//			record.setProcessed(true);
//			yourTableRepository.save(record); // Mark as processed
//		});
//		lastCheckedTime = new Timestamp(System.currentTimeMillis());
//	}


	
	System.out.println("count is ===================== " + ++number);

	if (number > 0){
		System.out.println("Reach number 10. do the logic................");
	List<TableData> arr = new ArrayList<>();
	arr = yourTableRepository.findAllById((long) number);
		System.out.println(arr);

	}
	

}

@GetMapping("/updates")
public List<TableData> getUnprocessedRecords() {
	return yourTableRepository.findUnprocessedRecords();
}

@PostMapping("/insert")
public TableData insertData(@RequestParam String data, @RequestParam boolean processed) {
	System.out.println("Done 01");
	return insertData.insertData(data, processed);

}

}