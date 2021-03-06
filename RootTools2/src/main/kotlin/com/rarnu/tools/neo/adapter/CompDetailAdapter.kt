package com.rarnu.tools.neo.adapter

import android.content.Context
import android.view.View
import android.widget.Switch
import android.widget.TextView
import com.rarnu.base.app.BaseAdapter
import com.rarnu.base.utils.ComponentUtils
import com.rarnu.tools.neo.R
import kotlinx.android.synthetic.main.listitem_compdetail.view.*

class CompDetailAdapter(context: Context, list: MutableList<ComponentUtils.CompInfo>?) : BaseAdapter<ComponentUtils.CompInfo, CompDetailAdapter.CompHolder>(context, list) {

    override fun fillHolder(baseVew: View, holder: CompHolder, item: ComponentUtils.CompInfo) {
        holder.setItem(item)
    }

    override fun getAdapterLayout(): Int = R.layout.listitem_compdetail

    override fun newHolder(baseView: View): CompHolder = CompHolder(baseView)

    override fun getValueText(item: ComponentUtils.CompInfo): String? = item.compName

    inner class CompHolder(v: View) {

        private var prefStatus: Switch? = null
        private var tvName: TextView? = null
        private var tvPackageName: TextView? = null

        internal fun setItem(item: ComponentUtils.CompInfo) {
            prefStatus?.isChecked = item.enabled
            tvName?.text = item.compName
            tvPackageName?.text = item.fullPackageName?.substring(0, item.fullPackageName!!.lastIndexOf("."))
        }

        init {
            prefStatus = v.prefStatus
            tvName = v.tvName
            tvPackageName = v.tvPackageName
        }
    }
}
