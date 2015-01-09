package com.comsysto.wicketBoot.wicket.bookTablePanel;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.comsysto.wicketBoot.data.entities.Book;
import com.comsysto.wicketBoot.wicket.WicketTestBase;

@RunWith(SpringJUnit4ClassRunner.class)
public class BookTablePanelTest extends WicketTestBase {

	@Test
	public void test() {
		final IDataProvider<Book> dataProvider = new ListDataProvider<>(asList(
				new Book("The Lord of the Rings", "J. R. R. Tolkien", "978-0007525546"), 
				new Book("Effective Java; A Proramming Language Guide", "Joshua Bloch", "978-0321356680"),
				new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "978-0345391803"),
				new Book("xUnit Test Patterns: Refactoring Test Code", "Gerard Meszaros", "978-0131495050")));

		final BookTablePanel panel = new BookTablePanel("test", dataProvider);
		panel.setItemsPerPage(3L);

		assertEquals(0, panel.getCurrentPage());
		assertEquals(2, panel.getPageCount());
	}
}
