package utils

import androidx.compose.ui.graphics.toComposeImageBitmap
import org.jetbrains.skia.Image
import java.net.URL

fun loadPicture(url: String) = Image.makeFromEncoded(URL(url).readBytes()).toComposeImageBitmap()