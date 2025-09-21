package com.jorgila.dragonballapp.ui.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.jorgila.dragonballapp.R
import com.jorgila.dragonballapp.domain.model.CharacterDetailModel
import com.jorgila.dragonballapp.domain.model.TransformationModel
import com.jorgila.dragonballapp.resource.Orange
import com.jorgila.dragonballapp.ui.home.DetailViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun DetailScreen(id: Int, navigateBack: () -> Unit ) {
    val viewModel : DetailViewModel = koinViewModel(parameters = { parametersOf(id) } )
    val detail by viewModel.character.collectAsState()

    Column {
        Spacer(modifier = Modifier.height(32.dp))
        detail?.let { character ->
            ItemDetail(character,navigateBack)
        } ?: run {
            CircularProgressIndicator(color = Orange)
        }
    }

}

@Composable
fun ItemDetail(character: CharacterDetailModel, navigateBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color.Black,
                        Orange
                    ),
                    startY = 0f,
                    endY = 450f
                )
            )
    ){
        Box(contentAlignment = Alignment.TopCenter){
            Card(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 48.dp,
                        top = 150.dp
                    )
                    .fillMaxSize()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(100.dp))
                    Text(
                        text = character.characterModel.name,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.Black,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Label(character.characterModel.race)
                        Spacer(modifier = Modifier.width(24.dp))
                        Label(character.characterModel.gender)
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Row(
                        modifier = Modifier.height(75.dp)
                    ) {
                        IconInformation(
                            Modifier.weight(1f),
                           R.drawable.ic_ki,
                            character.characterModel.ki
                        )
                        VerticalDivider(thickness = 2.dp)
                        IconInformation(
                            Modifier.weight(1f),
                            R.drawable.ic_planet,
                            character.originModel.name
                        )
                    }
                    TransformationList(Modifier.fillMaxSize(), character.transformations)
                }
            }
            AsyncImage(
                model = character.characterModel.image,
                contentDescription = "",
                modifier = Modifier
                    .size(250.dp)
                    .padding(vertical = 24.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back_24),
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(24.dp)
                        .clickable {
                            navigateBack()
                        }
                )
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
fun TransformationList(modifier: Modifier, transformations: List<TransformationModel>) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        if(transformations.isEmpty()){
            Text(text="No hay transformaciones a dia de hoy")
        }else{
            val pagerState = rememberPagerState(pageCount = {transformations.size } )
            HorizontalPager(
                pagerState,
                pageSize = PageSize.Fixed(150.dp),
                pageSpacing = 4.dp,
            ) { pos ->
                TransformationSticker(transformations[pos])
            }
        }
    }
}

@Composable
fun TransformationSticker(transformationModel: TransformationModel) {
    Card(
        border = BorderStroke(1.dp, Color.Gray.copy(0.4f)),
        modifier = Modifier
            .padding(horizontal = 6.dp, vertical = 24.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp)
    ) {
        Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
            AsyncImage(
                model = transformationModel.image,
                contentDescription = "",
                modifier = Modifier.weight(0.8f)
            )
            Text(
                text = transformationModel.name,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun IconInformation(modifier: Modifier, icon: Int, text: String) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = "",
            modifier = Modifier.size(48.dp)
        )
        Text(text = text, color = Color.Black)
    }
}

@Composable
fun Label(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .border(2.dp,Orange, RoundedCornerShape(25))
            .padding(horizontal = 10.dp, vertical = 6.dp)
    )
}