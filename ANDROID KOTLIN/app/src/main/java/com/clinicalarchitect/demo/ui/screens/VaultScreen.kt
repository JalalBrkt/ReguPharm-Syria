package com.clinicalarchitect.demo.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
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
import com.clinicalarchitect.demo.MockData.MOCK_VAULT_FILES

@Composable
fun VaultScreen() {
    val scrollState = rememberScrollState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF9FAFB))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Local Dossier Vault",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF212B36)
                )
                Text(
                    text = "Secure on-device storage",
                    fontSize = 14.sp,
                    color = Color(0xFF637381),
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

            // Search Bar & Filter
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 12.dp)
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
                            placeholder = { Text("Search dossiers...", color = Color(0xFF919EAB)) },
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color.Transparent,
                                unfocusedBorderColor = Color.Transparent
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color.White, RoundedCornerShape(8.dp))
                        .border(1.dp, Color(0xFFE5E8EB), RoundedCornerShape(8.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.FilterList,
                        contentDescription = null,
                        tint = Color(0xFF212B36)
                    )
                }
            }

            Column(
                modifier = Modifier
                    .verticalScroll(scrollState)
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Folders",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF212B36),
                    modifier = Modifier.padding(top = 16.dp, bottom = 12.dp)
                )

                val folders = MOCK_VAULT_FILES.filter { it.type == "folder" }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    FolderCard(folders[0], modifier = Modifier.weight(1f).padding(end = 8.dp))
                    FolderCard(folders[1], modifier = Modifier.weight(1f).padding(start = 8.dp))
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    FolderCard(folders[2], modifier = Modifier.weight(1f).padding(end = 8.dp))
                    Spacer(modifier = Modifier.weight(1f).padding(start = 8.dp))
                }

                Text(
                    text = "Recent Files",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF212B36),
                    modifier = Modifier.padding(top = 16.dp, bottom = 12.dp)
                )

                MOCK_VAULT_FILES.filter { it.type == "file" }.forEach { file ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp),
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
                                    .size(40.dp)
                                    .background(Color(0xFFF4F6F8), RoundedCornerShape(8.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                val icon = if (file.name.endsWith(".xlsx")) Icons.Filled.TableChart else Icons.Filled.Description
                                Icon(
                                    imageVector = icon,
                                    contentDescription = null,
                                    tint = Color(0xFF007B55),
                                    modifier = Modifier.size(24.dp)
                                )
                            }

                            Column(modifier = Modifier.padding(start = 16.dp)) {
                                Text(
                                    text = file.name,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = Color(0xFF212B36),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier.padding(bottom = 4.dp)
                                )
                                Text(
                                    text = "${file.size} • ${file.date}",
                                    fontSize = 13.sp,
                                    color = Color(0xFF637381)
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(80.dp))
            }
        }

        // FAB
        FloatingActionButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp),
            containerColor = Color(0xFF007B55),
            contentColor = Color.White,
            shape = CircleShape
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Add")
        }
    }
}

@Composable
fun FolderCard(folder: com.clinicalarchitect.demo.VaultFile, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Icon(
                imageVector = Icons.Filled.Folder,
                contentDescription = null,
                tint = Color(0xFF007B55),
                modifier = Modifier
                    .size(32.dp)
                    .padding(bottom = 12.dp)
            )
            Text(
                text = folder.name,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF212B36),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "${folder.count} items",
                fontSize = 13.sp,
                color = Color(0xFF637381)
            )
        }
    }
}
