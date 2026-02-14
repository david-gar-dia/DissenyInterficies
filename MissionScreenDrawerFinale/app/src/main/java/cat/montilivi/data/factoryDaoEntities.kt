package cat.montilivi.data

import cat.montilivi.data.impl.implDaoEntityInMemory
import cat.montilivi.data.interfaces.IEntityDao
import cat.montilivi.model.enums.Origin

object factoryDaoEntities {
    fun createDao(tipus: Origin): IEntityDao {
        return when(tipus) {
            Origin.MEMORY -> implDaoEntityInMemory;
            Origin.JSON -> TODO()
            Origin.SQLITE -> TODO()
            Origin.ROOM -> TODO()
            Origin.JDBC -> TODO()
        }
    }
}