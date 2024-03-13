package com.github.thinkami.hellojetbrainsplugin.ui

import com.intellij.ide.util.PropertiesComponent
import javax.swing.table.AbstractTableModel

class AppleTableModel : AbstractTableModel() {
    val allData: List<List<String>> = listOf(
        listOf("1", "シナノゴールド", "黄"),
        listOf("2", "シナノホッペ", "赤"),
        listOf("3", "ジョナゴールド", "赤"),
    )
    val columns: List<String> = listOf("No", "Name", "Color")

    var tableData: List<List<String>>
    val tableFilter: AppleTableFilter

    init {
        // 初期条件による絞り込みを実行するため、初期値を設定しておく
        tableData = allData.toList()

        tableFilter = AppleTableFilter(this)
        filterChanged()
    }

    override fun getRowCount(): Int {
        return tableData.size
    }

    override fun getColumnCount(): Int {
        return columns.size
    }

    override fun getValueAt(rowIndex: Int, columnIndex: Int): Any {
        return tableData[rowIndex][columnIndex]
    }

    override fun getColumnName(column: Int): String {
        return columns[column]
    }

    fun filterChanged() {
        tableData = allData.filter {
            val name = it[1] // Nameで絞り込むため、列番号を指定

            // 絞り込み条件を設定から取得して使用する
            val matchType = PropertiesComponent.getInstance().getValue("matchType")
            if (matchType == "Partial match") {
                name.contains(this.tableFilter.filterText)
            } else {
                name.startsWith(this.tableFilter.filterText)
            }
        }.toList() // allDataとは別オブジェクトにするため toList する

        // filterが更新されたことを通知する
        this.fireTableDataChanged()
    }
}