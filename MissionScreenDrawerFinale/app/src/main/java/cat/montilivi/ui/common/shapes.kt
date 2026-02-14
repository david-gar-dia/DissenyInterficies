package cat.montilivi.ui.common

import androidx.compose.foundation.shape.GenericShape
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin


val MedalRibbon = GenericShape(builder = { size, layout ->
    moveTo(0F, 0F)
    lineTo(size.width, 0F)
    lineTo(size.width, size.height)
    lineTo(0.5F * size.width, 0.9F * size.height)
    lineTo(0F, size.height)
    close()
})

val MedalStrength = GenericShape(builder = { size, layout ->
    moveTo(0F, 0.5F * size.height)
    lineTo(0.15F * size.width, 0.85F * size.height)
    lineTo(0.5F * size.width, 1F * size.height)
    lineTo(0.85F * size.width, 0.85F * size.height)
    lineTo(1F * size.width, 0.5F * size.height)
    lineTo(0.85F * size.width, 0.15F * size.height)
    lineTo(0.5F * size.width, 0F)
    lineTo(0.15F * size.width, 0.15F * size.height)
    close()
})

val MedalWeakness = GenericShape(builder = { size, layout ->
    moveTo(0F, 0F)
    lineTo(0.5F * size.width, 0.15F * size.height)
    lineTo(1F * size.width, 0F)
    lineTo(0.85F * size.width, 0.5F * size.height)
    lineTo(1F * size.width, 1F * size.height)
    lineTo(0.5F * size.width, 0.85F * size.height)
    lineTo(0F * size.width, 1F * size.height)
    lineTo(0.15F * size.width, 0.5F * size.height)
    close()
})

val TenPointStarShape = GenericShape { size, _ ->
    val cx = size.width / 2f
    val cy = size.height / 2f

    val outerRadius = size.minDimension / 2f
    val innerRadius = outerRadius * 0.7f

    val points = 10
    val angleStep = 2 * PI / points

    // Build the star automatically
    moveTo(
        (cx + cos(-PI / 2) * outerRadius).toFloat(),
        (cy + sin(-PI / 2) * outerRadius).toFloat()
    )

    for (i in 1 until points * 2) {
        val radius = if (i % 2 == 0) outerRadius else innerRadius
        val angle = i * (angleStep / 2) - PI / 2

        lineTo(
            (cx + cos(angle) * radius).toFloat(),
            (cy + sin(angle) * radius).toFloat()
        )
    }

    close()
}

val ZoneImageShape = GenericShape(builder = { size, layout ->

    moveTo(0F, 0F)

    lineTo(size.width * 0.25F, size.height * 0.05F)
    lineTo(size.width * 0.5F, 0F)
    lineTo(size.width * 0.75F, size.height * 0.05F)
    lineTo(size.width, 0F)

    lineTo(size.width * 0.95F, size.height * 0.25F)
    lineTo(size.width, size.height * 0.5F)
    lineTo(size.width * 0.95F, size.height * 0.75F)
    lineTo(size.width, size.height)

    lineTo(size.width * 0.75F, size.height * 0.95F)
    lineTo(size.width * 0.5F, size.height)
    lineTo(size.width * 0.25F, size.height * 0.95F)
    lineTo(0F, size.height)

    lineTo(size.width * 0.05F, size.height * 0.75F)
    lineTo(0F, size.height * 0.5F)
    lineTo(size.width * 0.05F, size.height * 0.25F)
    close()
})