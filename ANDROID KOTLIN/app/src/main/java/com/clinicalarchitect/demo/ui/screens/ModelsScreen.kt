package com.clinicalarchitect.demo.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.clinicalarchitect.demo.MockData.MOCK_MODELS

@Composable
fun ModelsScreen() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9FAFB))
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        Text(
            text = "Active Model Environment",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF212B36),
            modifier = Modifier.padding(bottom = 20.dp)
        )

        // Active Model Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(
                    modifier = Modifier.padding(bottom = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Memory,
                        contentDescription = null,
                        tint = Color(0xFF007B55),
                        modifier = Modifier.size(24.dp).padding(end = 12.dp)
                    )
                    Text(
                        text = MOCK_MODELS.active.name,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF212B36)
                    )
                }

                Text(
                    text = MOCK_MODELS.active.description,
                    fontSize = 15.sp,
                    color = Color(0xFF637381),
                    modifier = Modifier.padding(bottom = 20.dp),
                    lineHeight = 22.sp
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp)
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text("VERSION", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF919EAB), modifier = Modifier.padding(bottom = 4.dp))
                        Text(MOCK_MODELS.active.version ?: "", fontSize = 15.sp, fontWeight = FontWeight.Medium, color = Color(0xFF212B36))
                        Spacer(modifier = Modifier.height(16.dp))
                        Text("SIZE", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF919EAB), modifier = Modifier.padding(bottom = 4.dp))
                        Text(MOCK_MODELS.active.size, fontSize = 15.sp, fontWeight = FontWeight.Medium, color = Color(0xFF212B36))
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        Text("LAST UPDATED", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF919EAB), modifier = Modifier.padding(bottom = 4.dp))
                        Text(MOCK_MODELS.active.lastUpdated ?: "", fontSize = 15.sp, fontWeight = FontWeight.Medium, color = Color(0xFF212B36))
                    }
                }

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF161C24)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Icon(Icons.Filled.Refresh, contentDescription = null, tint = Color.White, modifier = Modifier.size(18.dp).padding(end = 8.dp))
                    Text("Check for Updates", color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        // Available Local Models
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Available Local Models", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF212B36))
            Text(
                text = "${MOCK_MODELS.available.size} Downloaded",
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF637381),
                modifier = Modifier
                    .background(Color(0xFFF4F6F8), RoundedCornerShape(12.dp))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            )
        }

        MOCK_MODELS.available.forEachIndexed { index, model ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(modifier = Modifier.padding(bottom = 16.dp)) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(Color(0xFFE5E8EB), RoundedCornerShape(8.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            val icon = if (index == 0) Icons.Filled.Speed else Icons.Filled.FindInPage
                            Icon(imageVector = icon, contentDescription = null, tint = Color(0xFF212B36), modifier = Modifier.size(20.dp))
                        }
                        Column(modifier = Modifier.padding(start = 16.dp)) {
                            Text(model.name, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color(0xFF212B36), modifier = Modifier.padding(bottom = 4.dp))
                            Text(model.description, fontSize = 14.sp, color = Color(0xFF637381), modifier = Modifier.padding(bottom = 8.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Filled.CheckCircle, contentDescription = null, tint = Color(0xFF007B55), modifier = Modifier.size(14.dp))
                                Text(model.status, fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF007B55), modifier = Modifier.padding(start = 6.dp, end = 12.dp))
                                Text(model.size, fontSize = 13.sp, color = Color(0xFF919EAB))
                            }
                        }
                    }
                    OutlinedButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF212B36)),
                        border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFC4CDD5))
                    ) {
                        Text("Select Model", fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                    }
                }
            }
        }

        // Cloud Repository
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Cloud Repository", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF212B36))
            Icon(Icons.Filled.Cloud, contentDescription = null, tint = Color(0xFF212B36), modifier = Modifier.size(24.dp))
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF4F6F8), RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            Column {
                MOCK_MODELS.cloud.forEachIndexed { index, item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = if (index == MOCK_MODELS.cloud.size - 1) 0.dp else 12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Row(modifier = Modifier.height(IntrinsicSize.Min)) {
                            if (index == 0) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .width(4.dp)
                                        .background(Color(0xFFFFA48D))
                                )
                            }
                            Column(modifier = Modifier.padding(16.dp)) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(bottom = 8.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    val typeText = if (item.type == "Update") "KNOWLEDGE BASE UPDATE" else "MODEL WEIGHTS"
                                    Text(typeText, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF637381), letterSpacing = 0.5.sp)
                                    if (item.tag != null) {
                                        Text(
                                            text = item.tag,
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(0xFFB72136),
                                            modifier = Modifier
                                                .background(Color(0xFFFFE4DE), RoundedCornerShape(4.dp))
                                                .padding(horizontal = 8.dp, vertical = 2.dp)
                                        )
                                    }
                                }
                                val cleanName = item.name.replace("Knowledge Base Update: ", "").replace("Model Weights: ", "")
                                Text(cleanName, fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color(0xFF212B36), modifier = Modifier.padding(bottom = 8.dp))
                                Text(item.description, fontSize = 14.sp, color = Color(0xFF637381), lineHeight = 20.sp, modifier = Modifier.padding(bottom = 16.dp))

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(item.size, fontSize = 13.sp, color = Color(0xFF637381))
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Text("Download", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF212B36), modifier = Modifier.padding(end = 6.dp))
                                        Icon(Icons.Filled.Download, contentDescription = null, tint = Color(0xFF212B36), modifier = Modifier.size(16.dp))
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
    }
}
