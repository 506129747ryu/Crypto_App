package com.tutorial.cryptoapp.Adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.majorik.sparklinelibrary.SparkLineLayout;
import com.tutorial.cryptoapp.Domain.CryptoWallet;
import com.tutorial.cryptoapp.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CryptoWalletAdapter extends RecyclerView.Adapter<CryptoWalletAdapter.Viewholder> {
    ArrayList<CryptoWallet> cryptoWallets;
    DecimalFormat formatter;

    public CryptoWalletAdapter(ArrayList<CryptoWallet> cryptoWallets) {
        this.cryptoWallets = cryptoWallets;
        formatter = new DecimalFormat("###,###,###,###");

    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_vallet,
                parent,
                false);
        return new Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.cryptoNameTxt.setText(cryptoWallets.get(position).getCryptoName());
        holder.cryptoPriceTxt.setText("$"+cryptoWallets.get(position).getCryptoPrice());
        holder.changePercentTxt.setText(cryptoWallets.get(position).getChangePercent() + "%");
        holder.propertySizeTxt.setText(cryptoWallets.get(position).getPropertySize()+ cryptoWallets.get(position).getCryptoSymbol());
        holder.propertyAmountTxt.setText("$"+formatter.format(cryptoWallets.get(position).getPropertyAmount()));

        if (cryptoWallets.get(position).getChangePercent() > 0){
            holder.changePercentTxt.setTextColor(Color.parseColor("#12C737"));
            holder.lineChart.setSparkLineColor(Color.parseColor("#12C737"));

        }else if (cryptoWallets.get(position).getChangePercent() < 0){
            holder.changePercentTxt.setTextColor(Color.parseColor("#FC0000"));
            holder.lineChart.setSparkLineColor(Color.parseColor("#FC0000"));
        }else {
            holder.changePercentTxt.setTextColor(Color.parseColor("#FFFFFF"));
            holder.lineChart.setSparkLineColor(Color.parseColor("#FFFFFF"));
        }

        holder.lineChart.setData(cryptoWallets.get(position).getLineData());

        int drawableResourceId = holder.itemView.getContext().getResources()
                .getIdentifier(cryptoWallets.get(position).getCryptoName(),
                        "drawable",
                        holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.logoCrypto);
    }

    @Override
    public int getItemCount() {
        return cryptoWallets.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView cryptoNameTxt, cryptoPriceTxt, changePercentTxt, propertySizeTxt, propertyAmountTxt;
        ImageView logoCrypto;
        SparkLineLayout lineChart;


        public Viewholder(@NonNull View itemView) {
            super(itemView);
            cryptoNameTxt = itemView.findViewById(R.id.cryptoNameTxt);
            cryptoPriceTxt = itemView.findViewById(R.id.cryptoPriceTxt);
            changePercentTxt = itemView.findViewById(R.id.changePercentTxt);
            propertySizeTxt = itemView.findViewById(R.id.propertySizeTxt);
            propertyAmountTxt = itemView.findViewById(R.id.propertyAmountTxt);

            logoCrypto = itemView.findViewById(R.id.logoImg);
            lineChart = itemView.findViewById(R.id.linesChart);
        }
    }
}
