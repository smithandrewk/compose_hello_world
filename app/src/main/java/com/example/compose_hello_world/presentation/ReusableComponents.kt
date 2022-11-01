package com.example.compose_hello_world.presentation

import android.widget.Switch
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.*
import androidx.wear.compose.material.dialog.Alert
import androidx.wear.compose.material.dialog.Dialog
import com.example.compose_hello_world.R

@Composable
fun ButtonExample(
    modifier: Modifier = Modifier,
    iconModifier: Modifier = Modifier
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.Center) {
        Button(modifier = Modifier.size(ButtonDefaults.LargeButtonSize),
        onClick = {}){
            Icon(
                painter = painterResource(id = R.drawable.lungs),
                contentDescription = "self-report button",
                modifier = iconModifier
            )
        }
    }
}
@Composable
fun TextExample(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colors.primary,
        text = stringResource(R.string.button_description)
    )
}
@Composable
fun CardExample(
    modifier: Modifier = Modifier,
    iconModifier: Modifier = Modifier
) {
    AppCard(
        modifier = modifier,
        appImage = {
            Icon(
                painter = painterResource(id = R.drawable.activity),
                contentDescription = "triggers open message action",
                modifier = iconModifier
            )
        },
        appName = { Text("Delta") },
        time = { Text("12m") },
        title = { Text("Session Count") },
        onClick = { /* ... */ }
    ) {
        Text("13 sessions today")
    }
}
@Composable
fun ChipExample(
    modifier: Modifier = Modifier,
    iconModifier: Modifier = Modifier
) {
    Chip(
        modifier = modifier,
        onClick = { /* ... */ },
        label = {
            Text(
                text = "self report",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        icon = {
            Icon(
                painter = painterResource(id = R.drawable.lungs),
                contentDescription = "triggers meditation action",
                modifier = iconModifier
            )
        },
    )
}
@Composable
fun ToggleChipExample(modifier: Modifier = Modifier) {
    var checked by remember { mutableStateOf(true) }
    ToggleChip(
        modifier = modifier,
        checked = checked,
        toggleControl = {
            Icon(
                imageVector = ToggleChipDefaults.switchIcon(checked = checked),
                contentDescription = if (checked) "On" else "Off"
            )
        },
        onCheckedChange = {
            checked = it
        },
        label = {
            Text(
                text = "Sound",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    )
}
@Composable
fun ShowDialogExample(){
    Box {
        var showDialog by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Chip(
                onClick = { showDialog = true },
                label = { Text("Show dialog") },
                colors = ChipDefaults.secondaryChipColors(),
            )
        }
        val scrollState = rememberScalingLazyListState()
        Dialog(
            showDialog = showDialog,
            onDismissRequest = { showDialog = false },
            scrollState = scrollState,
        ) {
            Alert(
                scrollState = scrollState,
                verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                contentPadding =
                PaddingValues(start = 10.dp, end = 10.dp, top = 24.dp, bottom = 52.dp),
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.lungs),
                        contentDescription = "airplane",
                        modifier = Modifier.size(24.dp)
                            .wrapContentSize(align = Alignment.Center),
                    )
                },
                title = { Text(text = "Example Title Text", textAlign = TextAlign.Center) },
                message = {
                    Text(
                        text = "Message content goes here",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body2
                    )
                },
            ) {
                item {
                    Chip(
                        label = { Text("Primary") },
                        onClick = { showDialog = false },
                        colors = ChipDefaults.primaryChipColors(),
                    )
                }
                item {
                    Chip(
                        label = { Text("Secondary") },
                        onClick = { showDialog = false },
                        colors = ChipDefaults.secondaryChipColors(),
                    )
                }
            }
        }
    }
}