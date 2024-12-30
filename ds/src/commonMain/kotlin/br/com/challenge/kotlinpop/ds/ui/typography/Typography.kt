package br.com.challenge.kotlinpop.ds.ui.typography

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import br.com.challenge.kotlinpop.common.util.typography.KotlinPopTypographyVariables
import br.com.challenge.kotlinpop.ds.ui.color.KotlinPopColorBaselineText
import githubkotlinpop.ds.generated.resources.Res
import githubkotlinpop.ds.generated.resources.asus_bold
import githubkotlinpop.ds.generated.resources.asus_bold_italic
import githubkotlinpop.ds.generated.resources.asus_light
import githubkotlinpop.ds.generated.resources.asus_light_italic
import githubkotlinpop.ds.generated.resources.asus_regular
import org.jetbrains.compose.resources.Font

@Composable
fun LTAsusFontFamily(): FontFamily {
    return FontFamily(
        Font(resource = Res.font.asus_bold, weight = FontWeight.Bold, style = FontStyle.Normal),
        Font(resource = Res.font.asus_bold_italic, weight = FontWeight.Bold, style = FontStyle.Italic),
        Font(resource = Res.font.asus_regular, weight = FontWeight.Normal, style = FontStyle.Normal),
        Font(resource = Res.font.asus_light, weight = FontWeight.Light, style = FontStyle.Normal),
        Font(resource = Res.font.asus_light_italic, weight = FontWeight.Medium, style = FontStyle.Italic)
    )
}

object HelloDevTypography {
    // Heading
    val headingDisplay = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        fontSize = KotlinPopTypographyVariables.FontSize.DisplayXL,
        lineHeight = KotlinPopTypographyVariables.LineHeight.Medium,
        color = KotlinPopColorBaselineText
    )
    val headingXL = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        fontSize = KotlinPopTypographyVariables.FontSize.HeadingXL,
        lineHeight = KotlinPopTypographyVariables.LineHeight.Medium,
        color = KotlinPopColorBaselineText
    )
    val headingMD = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        fontSize = KotlinPopTypographyVariables.FontSize.HeadingMD,
        lineHeight = KotlinPopTypographyVariables.LineHeight.Medium,
        color = KotlinPopColorBaselineText
    )
    val headingSM = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        fontSize = KotlinPopTypographyVariables.FontSize.HeadingSM,
        lineHeight = KotlinPopTypographyVariables.LineHeight.Distant,
        color = KotlinPopColorBaselineText
    )
    val headingXS = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        fontSize = KotlinPopTypographyVariables.FontSize.HeadingXS,
        lineHeight = KotlinPopTypographyVariables.LineHeight.Medium,
        color = KotlinPopColorBaselineText
    )
    val headingMini = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        fontSize = KotlinPopTypographyVariables.FontSize.HeadingMini,
        lineHeight = KotlinPopTypographyVariables.LineHeight.Medium,
        color = KotlinPopColorBaselineText
    )

    // Subtitle
    val subtitleLG = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Normal,
        fontSize = KotlinPopTypographyVariables.FontSize.SubtitleLG,
        lineHeight = KotlinPopTypographyVariables.LineHeight.Tight,
        color = KotlinPopColorBaselineText
    )
    val subtitleMD = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Normal,
        fontSize = KotlinPopTypographyVariables.FontSize.SubtitleMD,
        lineHeight = KotlinPopTypographyVariables.LineHeight.Tight,
        color = KotlinPopColorBaselineText
    )
    val subtitleSM = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Normal,
        fontSize = KotlinPopTypographyVariables.FontSize.SubtitleSM,
        lineHeight = KotlinPopTypographyVariables.LineHeight.Distant,
        color = KotlinPopColorBaselineText
    )

    // Paragraph
    val paragraphXL = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Light,
        fontSize = KotlinPopTypographyVariables.FontSize.ParagraphXL,
        lineHeight = KotlinPopTypographyVariables.LineHeight.SuperDistant,
        color = KotlinPopColorBaselineText
    )
    val paragraphLG = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Light,
        fontSize = KotlinPopTypographyVariables.FontSize.ParagraphLG,
        lineHeight = KotlinPopTypographyVariables.LineHeight.SuperDistant,
        color = KotlinPopColorBaselineText
    )
    val paragraphMD = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Light,
        fontSize = KotlinPopTypographyVariables.FontSize.ParagraphMD,
        lineHeight = KotlinPopTypographyVariables.LineHeight.Medium,
        color = KotlinPopColorBaselineText
    )
    val paragraphSM = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Light,
        fontSize = KotlinPopTypographyVariables.FontSize.ParagraphSM,
        lineHeight = KotlinPopTypographyVariables.LineHeight.Tight,
        color = KotlinPopColorBaselineText
    )

    // Caption
    val captionMD = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Light,
        fontSize = KotlinPopTypographyVariables.FontSize.CaptionMD,
        lineHeight = KotlinPopTypographyVariables.LineHeight.Tight,
        color = KotlinPopColorBaselineText
    )
    val captionMDBold = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        fontSize = KotlinPopTypographyVariables.FontSize.CaptionMDBold,
        lineHeight = KotlinPopTypographyVariables.LineHeight.Tight,
        color = KotlinPopColorBaselineText
    )
    val captionSM = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Light,
        fontSize = KotlinPopTypographyVariables.FontSize.CaptionSM,
        lineHeight = KotlinPopTypographyVariables.LineHeight.Distant,
        color = KotlinPopColorBaselineText
    )
    val captionSMBold = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        fontSize = KotlinPopTypographyVariables.FontSize.CaptionSMBold,
        lineHeight = KotlinPopTypographyVariables.LineHeight.Tight,
        color = KotlinPopColorBaselineText
    )
}