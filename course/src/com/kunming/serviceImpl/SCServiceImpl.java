package com.kunming.serviceImpl;

import java.util.List;

import com.kunming.bean.SC;
import com.kunming.dao.SCDao;
import com.kunming.daoImpl.SCDaoImpl;
import com.kunming.service.SCService;

public class SCServiceImpl implements SCService{
	SCDao scDao = new SCDaoImpl();
	@Override
	public List<SC> getAllSc() {
		// TODO Auto-generated method stub
		return scDao.getAllsc();
	}
	@Override
	public List<SC> getSCById(int sno) {
		// TODO Auto-generated method stub
		return scDao.getSCById(sno);
	}
	@Override
	public List<SC> getAllSC01() {
		// TODO Auto-generated method stub
		return scDao.getAllSC01();
	}
	@Override
	public List<SC> getSCBySno(int cno) {
		// TODO Auto-generated method stub
		return scDao.getSCBySno(cno);
	}
	@Override
	public List<SC> getSCBySname(String sname) {
		// TODO Auto-generated method stub
		return scDao.getSCBySname(sname);
	}
	@Override
	public List<SC> getSCBySclass(String sclass) {
		// TODO Auto-generated method stub
		return scDao.getSCBySclass(sclass);
	}
	@Override
	public List<SC> getSCByCname(String cname) {
		// TODO Auto-generated method stub
		return scDao.getSCByCname(cname);
	}
	@Override
	public List<SC> getSCByCno(int cno) {
		// TODO Auto-generated method stub
		return scDao.getSCByCno(cno);
	}
	@Override
	public List<SC> getSCByClassroom(String classroom) {
		// TODO Auto-generated method stub
		return scDao.getSCByClassroom(classroom);
	}
	@Override
	public SC getSCBySnoCno(int sno, int cno) {
		// TODO Auto-generated method stub
		return scDao.getSCBySnoCno(sno, cno);
	}
	@Override
	public int updateSC(SC sc) {
		// TODO Auto-generated method stub
		return scDao.updateSC(sc);
	}
	@Override
	public int[] insertSC(SC[] sc) {
		// TODO Auto-generated method stub
		return scDao.insertSC(sc);
	}
	@Override
	public List<SC> getStudentCourse(int sno) {
		// TODO Auto-generated method stub
		return scDao.getStudentCourse(sno);
	}
	@Override
	public int deleteStudentCourse(int sno, int cno) {
		// TODO Auto-generated method stub
		return scDao.deleteStudentCourse(sno, cno);
	}
}
