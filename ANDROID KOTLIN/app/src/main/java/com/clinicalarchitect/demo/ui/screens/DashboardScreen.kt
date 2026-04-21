package com.clinicalarchitect.demo.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material.icons.filled.MonitorHeart
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DashboardScreen() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.padding(bottom = 24.dp)) {
            Text(
                text = "Welcome back, Analyst",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF212B36)
            )
            Text(
                text = "System Status: Online",
                fontSize = 16.sp,
                color = Color(0xFF637381),
                modifier = Modifier.padding(top = 4.dp)
            )
        }

        // Metrics Grid
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            MetricCard(
                icon = Icons.Filled.MonitorHeart,
                color = Color(0xFF007B55),
                value = "24",
                label = "Analyses Today",
                modifier = Modifier.weight(1f).padding(end = 8.dp)
            )
            MetricCard(
                icon = Icons.Filled.VerifiedUser,
                color = Color(0xFF2E8540),
                value = "12",
                label = "Compliant",
                modifier = Modifier.weight(1f).padding(start = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            MetricCard(
                icon = Icons.Filled.ErrorOutline,
                color = Color(0xFFFF4842),
                value = "8",
                label = "Critical Flags",
                modifier = Modifier.weight(1f).padding(end = 8.dp)
            )
            MetricCard(
                icon = Icons.Filled.AccessTime,
                color = Color(0xFFFFA48D),
                value = "4",
                label = "Pending Review",
                modifier = Modifier.weight(1f).padding(start = 8.dp)
            )
        }

        // Recent Activity Section
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Recent Activity",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF212B36),
            modifier = Modifier.padding(bottom = 12.dp)
        )

        ActivityItem(
            text = "Dexlansoprazole 60mg - Analysis Completed",
            time = "2 mins ago"
        )
        ActivityItem(
            text = "Stability Data Summary.xlsx - Uploaded",
            time = "1 hour ago"
        )
    }
}

@Composable
fun MetricCard(
    icon: ImageVector,
    color: Color,
    value: String,
    label: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = color,
                modifier = Modifier.size(32.dp)
            )
            Text(
                text = value,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF212B36),
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = label,
                fontSize = 14.sp,
                color = Color(0xFF637381),
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

@Composable
fun ActivityItem(text: String, time: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = text,
                fontSize = 14.sp,
                color = Color(0xFF212B36)
            )
            Text(
                text = time,
                fontSize = 12.sp,
                color = Color(0xFF919EAB),
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}
