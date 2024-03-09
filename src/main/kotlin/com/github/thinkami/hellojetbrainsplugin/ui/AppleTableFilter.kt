package com.github.thinkami.hellojetbrainsplugin.ui

// modelをコンストラクタで受け取りつつプロパティとして定義
class AppleTableFilter(val model: AppleTableModel){
    var filterText: String = ""
    set(value) {
        if (value != filterText) {
            // 絞り込み文字列に変更があった場合のみ、プロパティを更新してモデルに変更があったことを通知する
            field = value
            this.model.filterChanged()
        }
    }
}