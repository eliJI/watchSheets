// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Create
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.system.exitProcess

var dat = Database()
@Composable
@Preview
fun App() {
  //var dat = Database()

    Box(
        modifier = Modifier.fillMaxSize().background(Color.LightGray)
    ) {
        search(dat.contentList)
        add()
    }
}


@Composable
fun add(){
    Row(
        modifier = Modifier.padding(15.dp).fillMaxSize(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.Bottom,


    ){
        FloatingActionButton(onClick = {}, modifier = Modifier){
          Text(text="Add a show", modifier = Modifier.padding(all=20.dp))
        }
    }
}



@Composable
fun showList(list:ArrayList<MediaObject>,value:String){

    if (value == "" || value == null) {

        LazyColumn(
            modifier = Modifier.absolutePadding(Dp(15f), Dp(80f), Dp(15f), Dp(15f)),
            verticalArrangement = Arrangement.Bottom
        ) {
            items(list.size) { index ->
                Text(modifier = Modifier.padding(Dp(0f), Dp(15f)), text = list[index].title, fontSize = 20.sp)
                Divider()
            }


        }
    }

    else{
        LazyColumn(
            modifier = Modifier.absolutePadding(Dp(15f), Dp(80f), Dp(15f), Dp(15f)),
            verticalArrangement = Arrangement.Bottom
        ) {
            item {
                for (show in list)
                {
                    if (show.title == value)
                    {
                        Text(modifier = Modifier.padding(Dp(0f), Dp(15f)), text = show.title, fontSize = 20.sp)
                        Divider()
                    }
                }
            }


        }
    }

}

@Composable
fun search(list:ArrayList<MediaObject>){
    var searchVal by rememberSaveable { mutableStateOf("") }
    val roundedCornerShape = RoundedCornerShape(50)
    showList(list,searchVal)

    Row(modifier = Modifier.padding(all=15.dp).fillMaxSize(),
        horizontalArrangement = Arrangement.End
    ){
        OutlinedTextField(
            searchVal,
            onValueChange = {searchVal=it},
            label = {Text(text="search")},
            maxLines = 1,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Gray,
                backgroundColor = Color.Transparent,
            ),
            shape = roundedCornerShape
        )
    }

}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()


    }



}
