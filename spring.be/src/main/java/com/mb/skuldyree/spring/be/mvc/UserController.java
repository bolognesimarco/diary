package com.mb.skuldyree.spring.be.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mb.skuldyree.spring.be.dao.SchoolClassRepository;
import com.mb.skuldyree.spring.be.dao.UserRepository;
import com.mb.skuldyree.spring.be.model.DayHourEnum;
import com.mb.skuldyree.spring.be.model.DayHourSchedule;
import com.mb.skuldyree.spring.be.model.Headmaster;
import com.mb.skuldyree.spring.be.model.Schedule;
import com.mb.skuldyree.spring.be.model.Scholar;
import com.mb.skuldyree.spring.be.model.SchoolClass;
import com.mb.skuldyree.spring.be.model.SexEnum;
import com.mb.skuldyree.spring.be.model.Subject;
import com.mb.skuldyree.spring.be.model.Teacher;
import com.mb.skuldyree.spring.be.model.User;
import com.mb.skuldyree.spring.be.model.WeekDayEnum;
import com.mb.skuldyree.spring.be.model.WeekDaySchedule;

@Controller
@RequestMapping(path="/api/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SchoolClassRepository schoolClassRepository;
	
	@GetMapping(path="/{id}")
	public @ResponseBody User getUser(@PathVariable("id") Long id) {
		return userRepository.findOne(id);
	}
	
	@GetMapping(path="/")
	public @ResponseBody User login(@RequestParam("username") String username, @RequestParam("password") String password) {
		List<User> found = userRepository.findByUsername(username);
		if(found == null || found.size() == 0 || !found.get(0).getPassword().equals(password)) {
			return null;
		}
		return found.get(0);
	}
	
	@GetMapping(path="/test2")
	public @ResponseBody String go2() {
		SchoolClass found = schoolClassRepository.findOne(4L);
		return found.getSchedule().getWeekDaySchedules().last().getWeekDay().name();
	}
	
	@GetMapping(path="/test")
	public @ResponseBody Long go() {
		
		Teacher branca = new Teacher();
		branca.setEmail("brancatelli.roberta@gmail.com");
		branca.setName("Roberta");
		branca.setPassword("branca");
		branca.setSex(SexEnum.FEMALE);
		branca.setSurname("Brancatelli");
		branca.setUsername("branca");
		
		userRepository.save(branca);
		
		Scholar gio = new Scholar();
		gio.setEmail("giorgiabolo05@gmail.com");
		gio.setName("Giorgia");
		gio.setPassword("gio");
		gio.setSex(SexEnum.FEMALE);
		gio.setSurname("Bolognesi");
		gio.setUsername("gio");
		
		userRepository.save(gio);
		
		Headmaster bolo = new Headmaster();
		bolo.setEmail("bolognesi.marco@gmail.com");
		bolo.setName("Marco");
		bolo.setPassword("bolo");
		bolo.setSex(SexEnum.MALE);
		bolo.setSurname("Bolognesi");
		bolo.setUsername("bolo");
		
		userRepository.save(bolo);
		
		SchoolClass classeGiorgia = new SchoolClass();
		classeGiorgia.setName("IIA");
			classeGiorgia.setHeadmaster(bolo);
			bolo.getClasses().add(classeGiorgia);
		
		//SUBJECTS
		Subject mate = new Subject();
		mate.setName("matematica");		
			classeGiorgia.getSubjects().add(mate);
			mate.setSchoolClass(classeGiorgia);
		
		//ORARIO
		Schedule orario = new Schedule();
			classeGiorgia.setSchedule(orario);
			orario.setSchoolClass(classeGiorgia);
		
			//LUNEDI
			WeekDaySchedule lunedi = new WeekDaySchedule();
			lunedi.setWeekDay(WeekDayEnum.MONDAY);
				lunedi.setSchedule(orario);
				orario.getWeekDaySchedules().add(lunedi);
		
				//PRIMAORA
				DayHourSchedule primaOra = new DayHourSchedule();
				primaOra.setDayHour(DayHourEnum.FIRST);
				primaOra.setSubject(mate);		
					lunedi.getDayHourSchedules().add(primaOra);
					primaOra.setWeekDaySchedule(lunedi);
				
				//SECONDAORA
				DayHourSchedule secondaOra = new DayHourSchedule();
				secondaOra.setDayHour(DayHourEnum.SECOND);
				secondaOra.setSubject(mate);		
					lunedi.getDayHourSchedules().add(secondaOra);
					secondaOra.setWeekDaySchedule(lunedi);


			
			//MARTEDI
			WeekDaySchedule martedi = new WeekDaySchedule();
			martedi.setWeekDay(WeekDayEnum.TUESDAY);
				martedi.setSchedule(orario);
				orario.getWeekDaySchedules().add(martedi);
		
				//PRIMAORA
				DayHourSchedule primaOraM = new DayHourSchedule();
				primaOraM.setDayHour(DayHourEnum.FIRST);
				primaOraM.setSubject(mate);		
					martedi.getDayHourSchedules().add(primaOraM);
					primaOraM.setWeekDaySchedule(martedi);
				
				//SECONDAORA
				DayHourSchedule secondaOraM = new DayHourSchedule();
				secondaOraM.setDayHour(DayHourEnum.SECOND);
				secondaOraM.setSubject(mate);		
					martedi.getDayHourSchedules().add(secondaOraM);
					secondaOraM.setWeekDaySchedule(martedi);
		
		schoolClassRepository.save(classeGiorgia);
		
		
		return classeGiorgia.getId();
	}

}
