package com.example.hammersystemtest

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.Ro
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Menu : NavigationItem("Menu", R.drawable.ic_baseline_fastfood_24, "Меню")
    object Profile : NavigationItem("Profile", R.drawable.ic_baseline_person_24, "Профиль")
    object Cart : NavigationItem("Cart", R.drawable.ic_baseline_shopping_cart_24, "Корзина")

}
@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .height(56.dp)
                .padding(start = 16.dp)
                .width(94.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stringResource(R.string.moscow), fontSize = 16.sp,
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_expand_more_city),
                contentDescription = null,
                modifier = Modifier
                    .clickable { /* Add code later */ }
                    .padding(8.dp)

            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_qr_code_scanner_24),
            contentDescription = null,
            modifier = Modifier
                .clickable { /* Add code later */ }
                .padding(start = 240.dp)

        )
    }
}


@Composable
fun BottomNavigationBar() {
    val items = listOf(
        NavigationItem.Menu,
        NavigationItem.Profile,
        NavigationItem.Cart

    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.bottomBar),
        contentColor = Color.White
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = colorResource(id = R.color.itemBarSelected),
                unselectedContentColor = colorResource(id = R.color.itemBarUnselected),
                alwaysShowLabel = true,
                selected = false,
                onClick = {
                    /* Add code later */
                }
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun TopBarPreview() {

    TopBar()

}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {

    BottomNavigationBar()

}
