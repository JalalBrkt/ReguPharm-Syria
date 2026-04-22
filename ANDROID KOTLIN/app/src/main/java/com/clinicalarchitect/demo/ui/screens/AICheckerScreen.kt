package com.clinicalarchitect.demo.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.clinicalarchitect.demo.MockData.MOCK_ANALYSIS_RESULT
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun AICheckerScreen() {
    var inputText by remember { mutableStateOf("Dexlansoprazole 60mg") }
    var isAnalyzed by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val scrollState = rememberScrollState()

    if (isAnalyzed) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(16.dp)
        ) {
            Column(modifier = Modifier.padding(bottom = 20.dp)) {
                Text(
                    text = MOCK_ANALYSIS_RESULT.molecule,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF212B36)
                )
                Text(
                    text = "${MOCK_ANALYSIS_RESULT.dosage} • ${MOCK_ANALYSIS_RESULT.form}",
                    fontSize = 16.sp,
                    color = Color(0xFF637381),
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

            // Score Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp).fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Compliance Score",
                        fontSize = 16.sp,
                        color = Color(0xFF637381),
                        modifier = Modifier.padding(bottom = 12.dp)
                    )
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .border(8.dp, Color(0xFFFF4842), CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "${MOCK_ANALYSIS_RESULT.score}%",
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF212B36)
                        )
                    }
                    Text(
                        text = MOCK_ANALYSIS_RESULT.status,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFF4842),
                        modifier = Modifier.padding(top = 12.dp)
                    )
                }
            }

            Text(
                text = "Compliance Flags",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF212B36),
                modifier = Modifier.padding(top = 8.dp, bottom = 16.dp)
            )

            MOCK_ANALYSIS_RESULT.flags.forEach { flag ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Row(modifier = Modifier.height(IntrinsicSize.Min)) {
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(4.dp)
                                .background(Color(0xFFFF4842))
                        )
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(bottom = 8.dp)
                            ) {
                                val iconColor = when (flag.severity) {
                                    "critical" -> Color(0xFFFF4842)
                                    "high" -> Color(0xFFFFC107)
                                    else -> Color(0xFFFFA48D)
                                }
                                val icon = if (flag.severity == "critical") Icons.Filled.Cancel else Icons.Filled.Warning

                                Icon(
                                    imageVector = icon,
                                    contentDescription = null,
                                    tint = iconColor,
                                    modifier = Modifier.size(20.dp)
                                )
                                Text(
                                    text = flag.title,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF212B36),
                                    modifier = Modifier.padding(start = 8.dp)
                                )
                            }
                            Text(
                                text = flag.description,
                                fontSize = 14.sp,
                                color = Color(0xFF637381)
                            )
                        }
                    }
                }
            }

            Text(
                text = "Missing Requirements",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF212B36),
                modifier = Modifier.padding(top = 8.dp, bottom = 16.dp)
            )

            MOCK_ANALYSIS_RESULT.requirements.forEach { req ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(20.dp)
                                .border(2.dp, Color(0xFFC4CDD5), RoundedCornerShape(4.dp))
                        )
                        Text(
                            text = req.title,
                            fontSize = 15.sp,
                            color = Color(0xFF212B36),
                            modifier = Modifier.padding(start = 12.dp)
                        )
                    }
                }
            }

            Button(
                onClick = {
                    isAnalyzed = false
                    inputText = ""
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, bottom = 40.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF4F6F8)),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "New Analysis",
                    color = Color(0xFF212B36),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(16.dp)
        ) {
            Text(
                text = "Regulatory AI Assistant",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF212B36),
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "Local pharmaceutical compliance analysis",
                fontSize = 16.sp,
                color = Color(0xFF637381),
                modifier = Modifier.padding(bottom = 24.dp)
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFE5E8EB))
            ) {
                Column {
                    OutlinedTextField(
                        value = inputText,
                        onValueChange = { inputText = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp),
                        placeholder = { Text("Enter molecule name, active ingredient, or paste dossier summary here...") },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                            cursorColor = Color(0xFF007B55)
                        )
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFF4F6F8))
                            .border(1.dp, Color(0xFFE5E8EB))
                            .padding(8.dp)
                    ) {
                        TextButton(onClick = { /*TODO*/ }) {
                            Icon(Icons.Filled.Upload, contentDescription = null, tint = Color(0xFF637381), modifier = Modifier.size(20.dp))
                            Text("Upload Docs", color = Color(0xFF637381), fontSize = 14.sp, modifier = Modifier.padding(start = 6.dp))
                        }
                        TextButton(onClick = { /*TODO*/ }) {
                            Icon(Icons.Filled.Description, contentDescription = null, tint = Color(0xFF637381), modifier = Modifier.size(20.dp))
                            Text("Select from Vault", color = Color(0xFF637381), fontSize = 14.sp, modifier = Modifier.padding(start = 6.dp))
                        }
                    }
                }
            }

            Button(
                onClick = {
                    scope.launch {
                        delay(500)
                        isAnalyzed = true
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(bottom = 24.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007B55)),
                shape = RoundedCornerShape(8.dp)
            ) {
                Icon(Icons.Filled.Search, contentDescription = null, tint = Color.White, modifier = Modifier.size(20.dp).padding(end = 8.dp))
                Text("Analyze Compliance", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFE1F5ED), RoundedCornerShape(8.dp))
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Filled.CheckCircle, contentDescription = null, tint = Color(0xFF007B55), modifier = Modifier.size(20.dp).padding(end = 8.dp))
                Text("Using local model: Syria-Regulatory-Llama-v2.1", color = Color(0xFF004B36), fontSize = 14.sp)
            }
        }
    }
}
