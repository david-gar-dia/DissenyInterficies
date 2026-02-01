package cat.montilivi.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun GenericBadge(text: String, icon: Painter, color: Color, modifier: Modifier = Modifier)
{
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(50))
            .background(color)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Text(
            text = text.uppercase(),
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.width(5.dp))
        Icon(
            painter = icon,
            contentDescription = text,
            modifier = Modifier
                .size(20.dp)
        )
    }
}