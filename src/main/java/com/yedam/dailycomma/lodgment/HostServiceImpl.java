package com.yedam.dailycomma.lodgment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //빈등록
public class HostServiceImpl implements HostService {
	
	Log4jAdvice logAdvice = new Log4jAdvice();
	
	@Autowired HostDAOMybatis dao;
	
	@Override
	public int insertHost(LodgmentDTO dto) {
		logAdvice.beforeLog();
		System.out.println(dao);
		return dao.insertUser(dto);
	}

	@Override
	public int updatetHost(LodgmentDTO dto) {
		logAdvice.beforeLog();
		return 0;
	}

	@Override
	public int deleteHost(LodgmentDTO dto) {
		logAdvice.beforeLog();
		return 0;
	}

	@Override
	public LodgmentDTO getHost(LodgmentDTO dto) {
		logAdvice.beforeLog();
		return null;
	}

	@Override
	public List<LodgmentDTO> getHosts(HostSearchDTO searchDTO) {
		logAdvice.beforeLog();
		return null;
	}

	@Override
	public int getCnt(HostSearchDTO searchDTO) {
		logAdvice.beforeLog();
		return 0;
	}	
}
