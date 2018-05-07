package demo.dagger_mvp.screens.itemlist.list;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.dagger_mvp.R;
import demo.dagger_mvp.model.apimodel.SourceItemsModel;
import demo.dagger_mvp.screens.itemlist.ItemListActivity;
import rx.subjects.PublishSubject;

/**
 * Created by sony on 06-05-2018.
 */

public class ItemListViewHolder extends ViewHolder {

    ItemListActivity itemListActivity;
    View view;
    @BindView(R.id.item_image)
    ImageView item_image;

    @BindView(R.id.item_name)
    TextView item_name;

    @BindView(R.id.item_featured)
    ImageView item_featured;

    @BindView(R.id.error_image)
    ImageView error_image;

    @BindView(R.id.progressbar)
    ProgressBar progressbar;



    public ItemListViewHolder(View itemView, PublishSubject<Integer> clickSubject,ItemListActivity ctx) {
        super(itemView);
        this.view = itemView;
        this.itemListActivity=ctx;
        ButterKnife.bind(this, view);
        view.setOnClickListener(v -> clickSubject.onNext(getAdapterPosition())
        );
    }

    void bind (SourceItemsModel item){
        String url="";
        try {
            url =URLDecoder.decode(item.getItem_url(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Picasso.with(itemListActivity)
                .load(url)
                .fit()
                .into(item_image,new Callback() {
                    @Override
                    public void onError() {
                        // TODO Auto-generated method stub
                        error_image.setVisibility(View.VISIBLE);
                        progressbar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onSuccess() {
                        // TODO Auto-generated method stub
                        progressbar.setVisibility(View.GONE);
                    }

                });


            if(item.getFeatured_flag().equals("1")){
                item_featured.setVisibility(View.VISIBLE);
            }

        item_name.setText(TextUtils.isEmpty(item.getItem_name()) ? "Error" : item.getItem_name());

    }
}
