package example.chen.com.customview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ActivityListAdapter extends RecyclerView.Adapter<ActivityListAdapter.ActivityItemVH> {

    private List<ActivityItem> mActivityItems = new ArrayList<>();
    private Context mContext;
    private onActivityItemClick mListener;

    public ActivityListAdapter(Context context, List<ActivityItem> activityItems) {
        this.mContext = context;
        this.mActivityItems = activityItems;
    }

    @Override
    public ActivityItemVH onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        if (mContext == null) {
            mContext = viewGroup.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_item_layout, viewGroup, false);

        return new ActivityItemVH(view);
    }

    @Override
    public void onBindViewHolder(ActivityItemVH itemViewHolder, final int position) {
        itemViewHolder.mTextView.setText(mActivityItems.get(position).getTitle());
        itemViewHolder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d("ActivityListAdapter", "" + mActivityItems.size());
        return mActivityItems.size();
    }

    public class ActivityItemVH extends RecyclerView.ViewHolder {
        TextView mTextView;

        public ActivityItemVH(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.activity_item_tv);
        }
    }

    interface onActivityItemClick {
        void onClick(int position);
    }

    public void setActivityItems(List<ActivityItem> activityItems) {
        mActivityItems = activityItems;
    }

    public void setContext(Context context) {
        mContext = context;
    }

    public void setListener(onActivityItemClick listener) {
        mListener = listener;
    }
}
