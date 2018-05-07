package demo.dagger_mvp.screens.itemlist.itemlistdagger;

import dagger.Component;
import demo.dagger_mvp.application.builder.AppComponent;
import demo.dagger_mvp.screens.itemlist.ItemListActivity;

/**
 * Created by sony on 07-05-2018.
 */
@ItemListScope
@Component (dependencies = {AppComponent.class} , modules = {ItemListModule.class})
public interface ItemListComponent {
    void inject (ItemListActivity itemListActivity);
}
