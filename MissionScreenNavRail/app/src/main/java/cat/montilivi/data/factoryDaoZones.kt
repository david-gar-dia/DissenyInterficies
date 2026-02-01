package cat.montilivi.data

import cat.montilivi.data.impl.implDaoZoneInMemory
import cat.montilivi.data.interfaces.IZoneDao
import cat.montilivi.model.enums.Origin

object factoryDaoZones {
    fun createDao(tipus: Origin): IZoneDao {
        return when(tipus) {
            Origin.MEMORY -> implDaoZoneInMemory;
            Origin.JSON -> TODO()
            Origin.SQLITE -> TODO()
            Origin.ROOM -> TODO()
            Origin.JDBC -> TODO()
        }
    }
}