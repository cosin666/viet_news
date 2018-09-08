package com.viet.mine.adapter

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.viet.mine.R
import com.viet.mine.activity.MineWalletActivity

/**
 * @Description 卡片切换适配器
 * @Author null
 * @Email zongjia.long@merculet.io
 * @Version
 */
class CardRvAdapter(private val context: Context, private val list: List<MineWalletActivity.Entity>) : RecyclerView.Adapter<CardRvAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.wallet_card_item, parent, false)
        return ItemViewHolder(itemView)
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.iv.text = list[position].name
        holder.tv.text = list[position].count
        if (position == 0) {
            holder.cons.background = context.resources.getDrawable(R.drawable.shape_wallet_card_red)
            val params = ConstraintLayout.LayoutParams(ViewGroup.LayoutParams(dip2px(context, 300f), dip2px(context, 120f)))
            params.marginStart = dip2px(context, 16f)
            holder.cons.layoutParams = params
        } else {
            holder.cons.background = context.resources.getDrawable(R.drawable.shape_wallet_card_yellow)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iv: TextView = itemView.findViewById<View>(R.id.tv_wallet_name) as TextView
        val tv: TextView = itemView.findViewById<View>(R.id.tv_wallet_asset) as TextView
        val cons: ConstraintLayout = itemView.findViewById<View>(R.id.card) as ConstraintLayout

    }

    fun dip2px(context: Context, dpValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

}
