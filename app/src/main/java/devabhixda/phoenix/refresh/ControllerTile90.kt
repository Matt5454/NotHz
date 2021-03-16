package devabhixda.phoenix.refresh

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService

@SuppressLint("NewApi")
class ControllerTile90 : TileService() {
    override fun onStartListening() {
        super.onStartListening()
        val tile = qsTile
        tile.label = getString(R.string.set_90hz)
        tile.state = Tile.STATE_ACTIVE
        tile.icon = Icon.createWithResource(this, R.drawable.ic_refresh_black_24dp)
        tile.updateTile()
    }

    override fun onClick() {
        super.onClick()
        setRefreshRate(RefreshRate.Ninety)
    }

}
