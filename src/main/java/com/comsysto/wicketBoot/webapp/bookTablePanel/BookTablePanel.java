package com.comsysto.wicketBoot.webapp.bookTablePanel;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.AbstractPageableView;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;

import com.comsysto.wicketBoot.data.entities.Book;

/**
 * Panel to show all Books in the database.
 */
public class BookTablePanel extends Panel implements IPageable {

	private final static long DEFAULT_ITEMS_PER_PAGE = 3L;

	public final static String DATA_VIEW_ID = "dataView";
	public final static String REPEATING_VIEW_ID = "bookRows";
	public final static String NAVIGATOR_ID = "pagingNavigator";

	private final DataView<Book> dataView;

	public BookTablePanel(final String id, final IDataProvider<Book> dataProvider, final long itemsPerPage) {
		super(id);

		dataView = new DataView<Book>(DATA_VIEW_ID, dataProvider) {
			@Override
			protected void populateItem(final Item<Book> item) {
				final RepeatingView redirectView = new RepeatingView(REPEATING_VIEW_ID);
				redirectView.add(new Label(redirectView.newChildId(), item.getModelObject().getTitle()));
				redirectView.add(new Label(redirectView.newChildId(), item.getModelObject().getAuthor()));
				redirectView.add(new Label(redirectView.newChildId(), item.getModelObject().getIsbn()));
				item.add(redirectView);
			}
		};

		add(dataView);
		add(new PagingNavigator(NAVIGATOR_ID, dataView));

		setItemsPerPage(itemsPerPage);
	}

	public BookTablePanel(final String id, final IDataProvider<Book> dataProvider) {
		this(id, dataProvider, DEFAULT_ITEMS_PER_PAGE);
	}

	/**
	 * Sets the maximum number of items to show per page. The current page will
	 * also be set to zero
	 * 
	 * @param items
	 * 
	 * @see AbstractPageableView#setItemsPerPage(long)
	 */
	public void setItemsPerPage(final long items) {
		dataView.setItemsPerPage(items);
	}

	@Override
	public long getCurrentPage() {
		return dataView.getCurrentPage();
	}

	@Override
	public void setCurrentPage(final long page) {
		dataView.setCurrentPage(page);
	}

	@Override
	public long getPageCount() {
		return dataView.getPageCount();
	}
}
