package cat.montilivi.ui.pantalles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.montilivi.R

@Preview
@Composable
fun CoverScreen (onClick:()->Unit = {})
{

    Column(
        Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colorScheme.surfaceVariant)
        .padding(48.dp),
    )
    {
        Icon(
            painter = painterResource(R.drawable.logomontilivi) ,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().aspectRatio(3F),
            tint = MaterialTheme.colorScheme.onSurfaceVariant)
        Spacer (Modifier.height(48.dp))
        Divider(color = MaterialTheme.colorScheme.onSurfaceVariant,modifier= Modifier.height(15.dp))
        Spacer (Modifier.weight(1F))
        Text(text = "Portada de l'aplicació",
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center)
        Spacer (Modifier.weight(1F))
    }
}