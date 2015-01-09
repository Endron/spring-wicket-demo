package com.comsysto.wicketBoot.wicket.bookTablePanel;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;

import com.comsysto.wicketBoot.data.entities.Book;

/**
 * Panel to show all Books in the database.
 */
public class BookTablePanel extends Panel {

	public BookTablePanel(final String id, final IDataProvider<Book> dataProvider) {
		super(id);

		final DataView<Book> dataView = new DataView<Book>("dataView", dataProvider) {
			@Override
			protected void populateItem(final Item<Book> item) {
				final RepeatingView redirectView = new RepeatingView("bookRows");
				redirectView.add(new Label(redirectView.newChildId(), item.getModelObject().getTitle()));
				redirectView.add(new Label(redirectView.newChildId(), item.getModelObject().getAuthor()));
				redirectView.add(new Label(redirectView.newChildId(), item.getModelObject().getIsbn()));
				item.add(redirectView);
			}
		};
		dataView.setItemsPerPage(3);

		add(dataView);
		add(new PagingNavigator("pagingNavigator", dataView));
	}
}
