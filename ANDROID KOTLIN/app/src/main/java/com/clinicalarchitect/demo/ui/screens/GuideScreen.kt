package com.clinicalarchitect.demo.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.clinicalarchitect.demo.MockData.MOCK_GUIDES

@Composable
fun GuideScreen() {
    val scrollState = rememberScrollState()
    val categoriesScrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9FAFB))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Reference Guides",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF212B36)
            )
            Text(
                text = "Syrian MOH Guidelines & Protocols",
                fontSize = 14.sp,
                color = Color(0xFF637381),
                modifier = Modifier.padding(top = 4.dp)
            )
        }

        // Search Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .background(Color.White, RoundedCornerShape(8.dp))
                .border(1.dp, Color(0xFFE5E8EB), RoundedCornerShape(8.dp))
                .padding(horizontal = 12.dp, vertical = 4.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = null,
                    tint = Color(0xFF919EAB),
                    modifier = Modifier.size(20.dp)
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    placeholder = { Text("Search guidelines...", color = Color(0xFF919EAB)) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        // Categories
        Row(
            modifier = Modifier
                .horizontalScroll(categoriesScrollState)
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            CategoryPill("All", isActive = true)
            CategoryPill("Regulatory", isActive = false)
            CategoryPill("Clinical", isActive = false)
            CategoryPill("Quality", isActive = false)
        }

        // Guides List
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(horizontal = 16.dp)
        ) {
            MOCK_GUIDES.forEach { guide ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .background(Color(0xFFF4F6F8), RoundedCornerShape(12.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            val icon = when (guide.icon) {
                                "book" -> Icons.Filled.Book
                                "file-text" -> Icons.Filled.Description
                                "thermometer" -> Icons.Filled.Thermostat
                                "table" -> Icons.Filled.TableChart
                                else -> Icons.Filled.Description
                            }
                            Icon(
                                imageVector = icon,
                                contentDescription = null,
                                tint = Color(0xFF007B55),
                                modifier = Modifier.size(24.dp)
                            )
                        }

                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 16.dp)
                        ) {
                            Text(
                                text = guide.title,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFF212B36),
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.padding(bottom = 6.dp)
                            )
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = guide.category,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = Color(0xFF007B55),
                                    modifier = Modifier
                                        .background(Color(0xFFE1F5ED), RoundedCornerShape(4.dp))
                                        .padding(horizontal = 8.dp, vertical = 2.dp)
                                )
                                Text(
                                    text = " • ${guide.size} • ${guide.date}",
                                    fontSize = 13.sp,
                                    color = Color(0xFF637381),
                                    modifier = Modifier.padding(start = 6.dp)
                                )
                            }
                        }

                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Filled.Download,
                                contentDescription = null,
                                tint = Color(0xFF007B55)
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Composable
fun CategoryPill(text: String, isActive: Boolean) {
    val backgroundColor = if (isActive) Color(0xFF007B55) else Color.White
    val textColor = if (isActive) Color.White else Color(0xFF637381)
    val borderColor = if (isActive) Color(0xFF007B55) else Color(0xFFE5E8EB)

    Box(
        modifier = Modifier
            .padding(end = 8.dp)
            .background(backgroundColor, RoundedCornerShape(20.dp))
            .border(1.dp, borderColor, RoundedCornerShape(20.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
}
