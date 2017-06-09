package indah.com.wheaterapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import indah.com.wheaterapp.R;
import indah.com.wheaterapp.model.Forecastday;
import indah.com.wheaterapp.model.Hour;

public class HourlyAdapter extends RecyclerView.Adapter<HourlyAdapter.HourlyHolder> {
    private Forecastday forecastDay;

    public HourlyAdapter(Forecastday forecastDay) {
        this.forecastDay = forecastDay;
    }

    @Override
    public HourlyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_forcast_hours, parent, false);
        // Return a new holder instance
        return new HourlyHolder(contactView);
    }

    @Override
    public void onBindViewHolder(HourlyHolder holder, int position) {
        holder.bind(forecastDay.getHour().get(position));
    }

    @Override
    public int getItemCount() {
        return forecastDay.getHour().size();
    }

    public class HourlyHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.condition_ic_item_hour)
        ImageView conditionIcon;
        @BindView(R.id.hour_text_item)
        TextView hourItem;
        @BindView(R.id.max_temp_item_hour)
        TextView maxTempItem;
        @BindView(R.id.condition_hour)
        TextView conditionText;

        public HourlyHolder(final View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Hour hour) {
            Picasso.with(itemView.getContext()).load("http://".concat(hour.getCondition().getIconLink().substring(2, hour.getCondition().getIconLink().length()))).fit().centerCrop().into(conditionIcon);
            hourItem.setText(hour.getTime().split(" ")[1]);
            maxTempItem.setText(String.format("%s°", hour.getTempC()));
            conditionText.setText(String.format("%s", hour.getCondition().getConditionText()));

        }
    }
}
