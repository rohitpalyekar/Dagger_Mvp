package demo.dagger_mvp.screens.itemlist.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import demo.dagger_mvp.R;
import demo.dagger_mvp.model.apimodel.SourceItemsModel;
import demo.dagger_mvp.screens.itemlist.ItemListActivity;
import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by sony on 06-05-2018.
 */

public class ItemListAdapter extends RecyclerView.Adapter<ItemListViewHolder> {

    private final PublishSubject<Integer> itemClicks = PublishSubject.create();
    ArrayList<SourceItemsModel> listitem = new ArrayList<>();
    ItemListActivity ctx;


    public void swapItemAdapter(ArrayList<SourceItemsModel> listitem , ItemListActivity ctx) {
        this.listitem.clear();
        this.listitem.addAll(listitem);
        this.ctx=ctx;
        notifyDataSetChanged();
    }

    public Observable<Integer> observeClicks() {
        return itemClicks;
    }
    @Override
    public ItemListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_view, parent, false);
        return new ItemListViewHolder(view ,itemClicks,ctx);
    }

    @Override
    public void onBindViewHolder(ItemListViewHolder holder, int position) {

        SourceItemsModel itemsModel = listitem.get(position);
        holder.bind(itemsModel);
    }

    @Override
    public int getItemCount() {
        if (listitem != null && listitem.size() > 0) {
            return listitem.size();
        } else {
            return 0;
        }
    }
}
