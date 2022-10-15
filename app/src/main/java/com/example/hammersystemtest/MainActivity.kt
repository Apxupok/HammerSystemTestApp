package com.example.hammersystemtest

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.hammersystemtest.model.Banner
import com.example.hammersystemtest.ui.theme.HammerSystemTestTheme
import androidx.compose.material.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hammersystemtest.data.Datasource
import com.example.hammersystemtest.model.Menu
import com.example.hammersystemtest.model.ProductCategory


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestApp(Datasource().loadBanners(),Datasource().loadMenu(),Datasource().loadListProductCategory())

        }
    }
}


@Composable
fun TestApp(bannerList: List<Banner>,menuList: List<Menu>,productCategoryList: List<ProductCategory>){
    val lazyListState = rememberLazyListState()
    val scrollOffset= (112-lazyListState.firstVisibleItemScrollOffset-lazyListState.firstVisibleItemIndex*112)
    Scaffold (
        topBar = { TopBar()},
        bottomBar = { BottomNavigationBar()},
        content = {
            Column(

            ) {

                LazyRow(

                    modifier = Modifier
                        .fillMaxWidth()
                        .height((scrollOffset).dp)

                ) {
                    items(bannerList) { banners ->
                        BannersCard(banners)

                    }
                }
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, bottom = 32.dp)
                ) {
                    items(productCategoryList) { productCategory ->
                        ProductCategoryCard(productCategory)

                    }
                }
                LazyColumn(
                    state = lazyListState,
                    modifier = Modifier.background(color = colorResource(id = R.color.backGroundMenu))
                ) {
                    items(menuList) { menu ->
                        MenuCard(menu)

                    }
                }

            }
        }
    )
}


@Composable
fun BannersCard(banner: Banner){
    Image(
        painter = painterResource(banner.imageResourceId),
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        modifier = Modifier
            .width(304.dp)
            .height(112.dp)
            .padding(16.dp)
    )

}

@Composable
fun MenuCard(menu: Menu){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(167.dp)
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(menu.imageResourceId),
            contentDescription = null,
            modifier = Modifier
                .height(135.dp)
                .width(135.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(22.dp))
        Column() {
            Text(
                text = stringResource(menu.stringTitleResourceId),
                modifier = Modifier
                    .height(19.dp)
                    .width(127.dp)
                    .size(16.dp),
            )
            Text(
                text = stringResource(menu.stringDescriptionResourceId),
                modifier = Modifier
                    .height(68.dp)
                    .width(171.dp)
                    .size(14.dp)
                    .weight(0.5f)
            )
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(87.dp,32.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.white)),
                border = BorderStroke(1.dp, colorResource(id = R.color.itemBarSelected))

                    
            ) {
                Text(
                    text = stringResource(id = menu.stringPriceResourceId),
                    color = colorResource(id = R.color.itemBarSelected)

                )
            }
        }

    }
}
@Composable
fun ProductCategoryCard(productCategory: ProductCategory){
    Button(onClick = { /*TODO*/ },
        modifier = Modifier
            .padding(end = 8.dp)
            .size(88.dp, 32.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.white))

    ) {
        Text(
            text = stringResource(id = productCategory.stringNameResourceId),
            textAlign = TextAlign.Center,
            fontSize = 11.sp,
            color = colorResource(id = R.color.buttonTextCategory)

        )

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HammerSystemTestTheme {
        TestApp(Datasource().loadBanners(),Datasource().loadMenu(),Datasource().loadListProductCategory())
    }
}