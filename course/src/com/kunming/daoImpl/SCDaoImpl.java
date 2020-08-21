package com.kunming.daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.kunming.bean.Course;
import com.kunming.bean.SC;
import com.kunming.bean.Student;
import com.kunming.dao.SCDao;
import com.kunming.jdbc.JdbcUtils;

public class SCDaoImpl implements SCDao {
	private QueryRunner qr = new QueryRunner (JdbcUtils.getDataSource());
	@Override
	public List<SC> getAllsc() {
		//多表联合查询
		String sql = "select s.sno as sno,s.sname as sname,s.sclass as class,s.spassword as spassword,s.ssex as sex,sum(c.ccredit) as ccredit from student s,sc sc,course c where s.sno=sc.sno and sc.cno=c.cno group by s.sno";
		
		try {
			List<Map<String, Object>> query = qr.query(sql, new MapListHandler());
			List<SC> list = new ArrayList<>();
			for (Map map:query) {
				SC sc = new SC();
				BeanUtils.populate(sc, map);
				Student student = new Student();
				BeanUtils.populate(student, map);
				Course course = new Course();
				BeanUtils.populate(course, map);
				
				sc.setCourse(course);
				sc.setStudent(student);
				list.add(sc);
				
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<SC> getSCById(int sno) {
		String sql="select s.sno as sno,s.sname as sname,s.spassword as spassword,s.sclass as sclass, s.ssex as ssex,sum(c.ccredit) as ccredit from student s,sc sc,course c where s.sno=sc.sno and sc.cno=c.cno and s.sno=? group by s.sno";
		try {
			List<Map<String, Object>> query = qr.query(sql, new MapListHandler(),sno);
			ArrayList<SC> list = new ArrayList<>();
			for(Map map:query) {
				SC sc = new SC();
				BeanUtils.populate(sc, map);
				Student student = new Student();
				BeanUtils.populate(student, map);
				Course course = new Course();
				BeanUtils.populate(course, map);
				sc.setCourse(course);
				sc.setStudent(student);
				list.add(sc);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<SC> getAllSC01() {
		String sql="select s.sno as sno,s.sname as sname,s.spassword as spassword,s.sclass as sclass, s.ssex as ssex,c.cno as cno ,c.cname as cname,sc.classroom as classroom from student s,sc sc,course c where s.sno=sc.sno and sc.cno=c.cno";
		try {
			List<Map<String, Object>> query = qr.query(sql, new MapListHandler());
			List<SC> list=new ArrayList<>();
			for (Map map:query) {
				SC sc=new SC();
				BeanUtils.populate(sc, map);
				Student student=new Student();
				BeanUtils.populate(student, map);
				Course course=new Course();
				BeanUtils.populate(course, map);
				//所有的数据将要封装到sc中，怎么封装？第一种：使用setter，第二种构造方法
				//课程的信息和学生信息在表中是有关系，外键关系，但是在实体类中有关系，创建关系
				sc.setCourse(course);
				sc.setStudent(student);
				list.add(sc);
				
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	@Override
	public List<SC> getBySC(Student s, SC sc, Course c) {
		String sql="select s.sno as sno,s.sname as sname,s.sclass as sclass, s.ssex as ssex,c.cno as cno,c.cname as cname,sc.classroom as classroom from student s,sc sc,course c where s.sno=sc.sno and sc.cno=c.cno and s.sno like '%"+s.getSno()+"%' or s.sname like '%"+s.getSname()+"%' or s.sclass like '%"+s.getSclass()+"%' or c.cno like '%"+c.getCno()+"%' or c.cname like '%"+c.getCname()+"%' or sc.classroom like '%"+sc.getClassroom()+"%'";
		try {
			List<Map<String, Object>> query = qr.query(sql, new MapListHandler());
			List<SC> list=new ArrayList<>();
			for (Map map:query) {
				SC sc01=new SC();
				BeanUtils.populate(sc01, map);
				Student student=new Student();
				BeanUtils.populate(student, map);
				Course course=new Course();
				BeanUtils.populate(course, map);
				//所有的数据将要封装到sc中，怎么封装？第一种：使用setter，第二种构造方法
				//课程的信息和学生信息在表中是有关系，外键关系，但是在实体类中有关系，创建关系
				sc.setCourse(course);
				sc.setStudent(student);
				list.add(sc01);
				
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<SC> getSCBySno(int sno) {
		String sql="select s.sno as sno,s.sname as sname,s.sclass as sclass, s.ssex as ssex,c.cno as cno,c.cname as cname,sc.classroom as classroom from student s,sc sc,course c where s.sno=sc.sno and sc.cno=c.cno and s.sno like '%"+sno+"%'";
		try {
			List<Map<String, Object>> query = qr.query(sql, new MapListHandler());
			List<SC> list=new ArrayList<>();
			for (Map map:query) {
				SC sc01=new SC();
				BeanUtils.populate(sc01, map);
				Student student=new Student();
				BeanUtils.populate(student, map);
				Course course=new Course();
				BeanUtils.populate(course, map);
				//所有的数据将要封装到sc中，怎么封装？第一种：使用setter，第二种构造方法
				//课程的信息和学生信息在表中是有关系，外键关系，但是在实体类中有关系，创建关系
				sc01.setCourse(course);
				sc01.setStudent(student);
				list.add(sc01);
				
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<SC> getSCBySname(String sname) {
		String sql="select s.sno as sno,s.sname as sname,s.sclass as sclass, s.ssex as ssex,c.cno as cno,c.cname as cname,sc.classroom as classroom from student s,sc sc,course c where s.sno=sc.sno and sc.cno=c.cno and s.sname like '%"+sname+"%'";
		try {
			List<Map<String, Object>> query = qr.query(sql, new MapListHandler());
			List<SC> list=new ArrayList<>();
			for (Map map:query) {
				SC sc01=new SC();
				BeanUtils.populate(sc01, map);
				Student student=new Student();
				BeanUtils.populate(student, map);
				Course course=new Course();
				BeanUtils.populate(course, map);
				//所有的数据将要封装到sc中，怎么封装？第一种：使用setter，第二种构造方法
				//课程的信息和学生信息在表中是有关系，外键关系，但是在实体类中有关系，创建关系
				sc01.setCourse(course);
				sc01.setStudent(student);
				list.add(sc01);
				
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
/***********************************************************/
	@Override
	public List<SC> getSCBySclass(String sclass) {
		String sql="select s.sno as sno,s.sname as sname,s.sclass as sclass, s.ssex as ssex,c.cno as cno,c.cname as cname,sc.classroom as classroom from student s,sc sc,course c where s.sno=sc.sno and sc.cno=c.cno and s.sclass like '%"+sclass+"%'";
		try {
			List<Map<String, Object>> query = qr.query(sql, new MapListHandler());
			List<SC> list=new ArrayList<>();
			for (Map map:query) {
				SC sc01=new SC();
				BeanUtils.populate(sc01, map);
				Student student=new Student();
				BeanUtils.populate(student, map);
				Course course=new Course();
				BeanUtils.populate(course, map);
				//所有的数据将要封装到sc中，怎么封装？第一种：使用setter，第二种构造方法
				//课程的信息和学生信息在表中是有关系，外键关系，但是在实体类中有关系，创建关系
				sc01.setCourse(course);
				sc01.setStudent(student);
				list.add(sc01);
				
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<SC> getSCByCname(String cname) {
		String sql="select s.sno as sno,s.sname as sname,s.sclass as sclass, s.ssex as ssex,c.cno as cno,c.cname as cname,sc.classroom as classroom from student s,sc sc,course c where s.sno=sc.sno and sc.cno=c.cno and c.cname like '%"+cname+"%'";
		try {
			List<Map<String, Object>> query = qr.query(sql, new MapListHandler());
			List<SC> list=new ArrayList<>();
			for (Map map:query) {
				SC sc01=new SC();
				BeanUtils.populate(sc01, map);
				Student student=new Student();
				BeanUtils.populate(student, map);
				Course course=new Course();
				BeanUtils.populate(course, map);
				//所有的数据将要封装到sc中，怎么封装？第一种：使用setter，第二种构造方法
				//课程的信息和学生信息在表中是有关系，外键关系，但是在实体类中有关系，创建关系
				sc01.setCourse(course);
				sc01.setStudent(student);
				list.add(sc01);
				
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<SC> getSCByCno(int cno) {
		String sql="select s.sno as sno,s.sname as sname,s.sclass as sclass, s.ssex as ssex,c.cno as cno,c.cname as cname,sc.classroom as classroom from student s,sc sc,course c where s.sno=sc.sno and sc.cno=c.cno and c.cno like '%"+cno+"%'";
		try {
			List<Map<String, Object>> query = qr.query(sql, new MapListHandler());
			List<SC> list=new ArrayList<>();
			for (Map map:query) {
				SC sc01=new SC();
				BeanUtils.populate(sc01, map);
				Student student=new Student();
				BeanUtils.populate(student, map);
				Course course=new Course();
				BeanUtils.populate(course, map);
				//所有的数据将要封装到sc中，怎么封装？第一种：使用setter，第二种构造方法
				//课程的信息和学生信息在表中是有关系，外键关系，但是在实体类中有关系，创建关系
				sc01.setCourse(course);
				sc01.setStudent(student);
				list.add(sc01);
				
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<SC> getSCByClassroom(String classroom) {
		String sql="select s.sno as sno,s.sname as sname,s.sclass as sclass, s.ssex as ssex,c.cno as cno,c.cname as cname,sc.classroom as classroom from student s,sc sc,course c where s.sno=sc.sno and sc.cno=c.cno and sc.classroom like '%"+classroom+"%'";
		try {
			List<Map<String, Object>> query = qr.query(sql, new MapListHandler());
			List<SC> list=new ArrayList<>();
			for (Map map:query) {
				SC sc01=new SC();
				BeanUtils.populate(sc01, map);
				Student student=new Student();
				BeanUtils.populate(student, map);
				Course course=new Course();
				BeanUtils.populate(course, map);
				//所有的数据将要封装到sc中，怎么封装？第一种：使用setter，第二种构造方法
				//课程的信息和学生信息在表中是有关系，外键关系，但是在实体类中有关系，创建关系
				sc01.setCourse(course);
				sc01.setStudent(student);
				list.add(sc01);
				
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public SC getSCBySnoCno(int sno, int cno) {
		String sql="select sno,cno,classroom from sc where sno=? and cno=?";
		try {
		return qr.query(sql, new BeanHandler<>(SC.class),sno,cno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateSC(SC sc) {
		String sql="update sc set classroom=? where sno=? and cno=?";
		try {
		return qr.update(sql,sc.getClassroom(),sc.getSno(),sc.getCno());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int[] insertSC(SC[] sc) {
		int[] res = new int[sc.length];//设置一个sc的长度的数据
		SC temp = null;
		String sql="insert into sc(sno,cno,classroom) values(?,?,?)";
		//如果是一条，那么for循环只循环一次，如果是多条那么for循环执行多次
		for(int i=0; i<sc.length;i++) {
			temp=sc[i];//就是sc实体类
			try {
				 qr.update(sql,sc[i].getSno(),sc[i].getCno(),sc[i].getClassroom());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<SC> getStudentCourse(int sno) {
		String sql="SELECT c.cno as cno,c.cname as cname,c.ccredit as ccredit,sc.classroom as classroom from student s,sc sc,course c where s.sno = sc.sno and sc.cno = c.cno and s.sno=?";
		try {
			List<Map<String, Object>> query = qr.query(sql, new MapListHandler(),sno);
			List<SC> list=new ArrayList<>();
			for (Map map:query) {
				SC sc01=new SC();
				BeanUtils.populate(sc01, map);
				Student student=new Student();
				BeanUtils.populate(student, map);
				Course course=new Course();
				BeanUtils.populate(course, map);
				//所有的数据将要封装到sc中，怎么封装？第一种：使用setter，第二种构造方法
				//课程的信息和学生信息在表中是有关系，外键关系，但是在实体类中有关系，创建关系
				sc01.setCourse(course);
				sc01.setStudent(student);
				list.add(sc01);
				
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
	
	
	
	public static void main(String[] args) {
		SCDao scDao = new SCDaoImpl();
		SC[] sc = new SC[3];
		SC sc01 = new SC();
		sc01.setClassroom("5");
		sc01.setCno(5);
		sc01.setSno(1514010929);
		sc[0] = sc01;
		SC sc02 = new SC();
		sc02.setClassroom("5");
		sc02.setCno(5);
		sc02.setSno(1514010926);
		sc[1] = sc02;
		scDao.insertSC(sc);
		
	}

	@Override
	public int deleteStudentCourse(int sno, int cno) {
		String sql="delete from sc where sno=? and cno=?";
		try {
		return qr.update(sql,sno,cno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
