package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.FinishClassDAO;
import kr.ac.hansung.model.FinishClass;

@Service
public class FinishClassService {

	@Autowired
	private FinishClassDAO finishClassDAO;

	public List<FinishClass> getCurrent() {
		
		return finishClassDAO.getFinishClasses();
	}

	public void insert(FinishClass finishclass) {

		finishClassDAO.insert(finishclass);
		
	}
	

}