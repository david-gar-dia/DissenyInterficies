package cat.montilivi.data

import cat.montilivi.data.impl.implDaoMissionInMemory
import cat.montilivi.data.interfaces.IMissionDao
import cat.montilivi.model.enums.Origin

object factoryDaoMissions {
    fun createDao(tipus: Origin): IMissionDao {
        return when(tipus) {
            Origin.MEMORY -> implDaoMissionInMemory;
            Origin.JSON -> TODO()
            Origin.SQLITE -> TODO()
            Origin.ROOM -> TODO()
            Origin.JDBC -> TODO()
        }
    }
}