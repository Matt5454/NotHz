package devabhixda.phoenix.refresh

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService


@SuppressLint("NewApi")
class ControllerTile120 : TileService() {
    private var currentRefreshRate = RefreshRate.HundredTwenty

    override fun onStartListening() {
        super.onStartListening()
        val tile = qsTile
        tile.label = getRefreshRateLabel(currentRefreshRate)
        tile.state = Tile.STATE_ACTIVE
        tile.icon = getRefreshRateIcon(currentRefreshRate)
        tile.updateTile()
    }

    override fun onClick() {
        super.onClick()
        currentRefreshRate = getNextRefreshRate(currentRefreshRate)
        setRefreshRate(currentRefreshRate)
        updateTile()
    }

    private fun getNextRefreshRate(refreshRate: RefreshRate): RefreshRate {
        return when (refreshRate) {
            RefreshRate.Sixty -> RefreshRate.Ninety
            RefreshRate.Ninety -> RefreshRate.HundredTwenty
            RefreshRate.HundredTwenty -> RefreshRate.Sixty
        }
    }

    private fun getRefreshRateLabel(refreshRate: RefreshRate): String {
        return when (refreshRate) {
            RefreshRate.Sixty -> getString(R.string.set_60hz)
            RefreshRate.Ninety -> getString(R.string.set_90hz)
            RefreshRate.HundredTwenty -> getString(R.string.set_120hz)
        }
    }

    private fun getRefreshRateIcon(refreshRate: RefreshRate): Icon {
        return when (refreshRate) {
            RefreshRate.Sixty -> Icon.createWithResource(this, R.drawable.ic_refresh_black_24dp)
            RefreshRate.Ninety -> Icon.createWithResource(this, R.drawable.ic_refresh_black_24dp)
            RefreshRate.HundredTwenty -> Icon.createWithResource(this, R.drawable.ic_refresh_black_24dp)
        }
    }

    private fun updateTile() {
        val tile = qsTile
        tile.label = getRefreshRateLabel(currentRefreshRate)
        tile.icon = getRefreshRateIcon(currentRefreshRate)
        tile.updateTile()
    }
}
