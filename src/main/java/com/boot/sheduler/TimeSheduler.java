package com.boot.sheduler;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import com.boot.dao.BookDao;
import com.boot.generators.EmailGenerator;
import com.boot.generators.PdfGenerator;
import com.boot.model.Book;

@Configuration
@EnableScheduling
public class TimeSheduler implements SchedulingConfigurer, Runnable {
	@Autowired
	private BookDao bDao;

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		Trigger trigger = new Trigger() {
			@Override
			public Date nextExecutionTime(TriggerContext triggerContext) {
				CronTrigger crontrigger = new CronTrigger("0 0/1 * 1/1 *  *");
				return crontrigger.nextExecutionTime(triggerContext);
			}
		};
		taskRegistrar.addTriggerTask(this::run, trigger);
	}

	@Override
	public void run() {
		List<Book> allBooks = bDao.getAllBooks();
		PdfGenerator.pdfGen(allBooks);
		EmailGenerator.generator("D:\\bookslist.pdf", "balakrishnaj59@gmail.com", "From TimeSheduler..!");
	}

}
