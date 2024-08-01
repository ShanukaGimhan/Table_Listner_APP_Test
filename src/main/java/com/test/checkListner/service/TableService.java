package com.test.checkListner.service;

import com.test.checkListner.repository.RepoClass;
import com.test.checkListner.entity.TableData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableService {
@Autowired
private RepoClass yourTableRepository;

public TableData insertData(String data, boolean processed) {
	TableData newRecord = new TableData();
	newRecord.setData(data);
	newRecord.setProcessed(processed);
	System.out.println(data);
	return yourTableRepository.save(newRecord);
}

}

