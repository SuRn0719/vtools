package com.omarea.vboot.dialogs

import android.app.AlertDialog
import android.content.Context
import com.omarea.shared.Consts
import com.omarea.shell.SuDo

/**
 * Created by helloklf on 2017/12/11.
 */

class DialogPower(var context:Context) {
    fun showPowerMenu () {
        AlertDialog.Builder(context).setTitle("请选择操作").setItems(arrayOf("快速关机", "快速重启", "热重启", "进入Fastboot", "进入Recovery", "进入9008模式"), {
            _,w ->
            val sudo = SuDo(context)
            when (w) {
                0 -> sudo.execCmdSync(Consts.RebootShutdown)
                1 -> sudo.execCmdSync(Consts.Reboot)
                2 -> sudo.execCmdSync(Consts.RebootHot)
                3 -> sudo.execCmdSync(Consts.RebootBootloader)
                4 -> sudo.execCmdSync(Consts.RebootRecovery)
                5 -> sudo.execCmdSync(Consts.RebootRecovery)
            }
        }).create().show()
    }
}
