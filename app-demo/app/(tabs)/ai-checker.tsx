import React, { useState } from 'react';
import { StyleSheet, ScrollView, View, Text, TextInput, TouchableOpacity } from 'react-native';
import { Upload, FileText, CheckCircle, AlertTriangle, XCircle, Search } from 'lucide-react-native';
import { MOCK_ANALYSIS_RESULT } from '@/constants/mockData';

export default function AICheckerScreen() {
  const [inputText, setInputText] = useState('Dexlansoprazole 60mg');
  const [isAnalyzed, setIsAnalyzed] = useState(false);

  const handleAnalyze = () => {
    // Simulate processing
    setTimeout(() => {
      setIsAnalyzed(true);
    }, 500);
  };

  const resetAnalyzer = () => {
    setIsAnalyzed(false);
    setInputText('');
  };

  if (isAnalyzed) {
    return (
      <ScrollView style={styles.container}>
        <View style={styles.resultHeader}>
          <Text style={styles.moleculeTitle}>{MOCK_ANALYSIS_RESULT.molecule}</Text>
          <Text style={styles.dosageForm}>{MOCK_ANALYSIS_RESULT.dosage} • {MOCK_ANALYSIS_RESULT.form}</Text>
        </View>

        <View style={styles.scoreContainer}>
          <Text style={styles.scoreLabel}>Compliance Score</Text>
          <View style={styles.scoreCircle}>
            <Text style={styles.scoreValue}>{MOCK_ANALYSIS_RESULT.score}%</Text>
          </View>
          <Text style={styles.statusLabel}>{MOCK_ANALYSIS_RESULT.status}</Text>
        </View>

        <Text style={styles.sectionTitle}>Compliance Flags</Text>
        {MOCK_ANALYSIS_RESULT.flags.map((flag) => (
          <View key={flag.id} style={styles.flagCard}>
            <View style={styles.flagHeader}>
              {flag.severity === 'critical' ? (
                <XCircle color="#ff4842" size={20} />
              ) : flag.severity === 'high' ? (
                <AlertTriangle color="#ffc107" size={20} />
              ) : (
                <AlertTriangle color="#ffa48d" size={20} />
              )}
              <Text style={styles.flagTitle}>{flag.title}</Text>
            </View>
            <Text style={styles.flagDescription}>{flag.description}</Text>
          </View>
        ))}

        <Text style={styles.sectionTitle}>Missing Requirements</Text>
        {MOCK_ANALYSIS_RESULT.requirements.map((req) => (
          <View key={req.id} style={styles.reqCard}>
            <View style={styles.reqCheckbox}></View>
            <Text style={styles.reqTitle}>{req.title}</Text>
          </View>
        ))}

        <TouchableOpacity style={styles.resetButton} onPress={resetAnalyzer}>
          <Text style={styles.resetButtonText}>New Analysis</Text>
        </TouchableOpacity>
      </ScrollView>
    );
  }

  return (
    <ScrollView style={styles.container}>
      <Text style={styles.pageTitle}>Regulatory AI Assistant</Text>
      <Text style={styles.pageSubtitle}>Local pharmaceutical compliance analysis</Text>

      <View style={styles.inputContainer}>
        <TextInput
          style={styles.textInput}
          multiline
          placeholder="Enter molecule name, active ingredient, or paste dossier summary here..."
          value={inputText}
          onChangeText={setInputText}
        />
        <View style={styles.actionRow}>
          <TouchableOpacity style={styles.iconButton}>
            <Upload color="#637381" size={20} />
            <Text style={styles.iconButtonText}>Upload Docs</Text>
          </TouchableOpacity>
          <TouchableOpacity style={styles.iconButton}>
            <FileText color="#637381" size={20} />
            <Text style={styles.iconButtonText}>Select from Vault</Text>
          </TouchableOpacity>
        </View>
      </View>

      <TouchableOpacity style={styles.analyzeButton} onPress={handleAnalyze}>
        <Search color="#ffffff" size={20} style={{ marginRight: 8 }} />
        <Text style={styles.analyzeButtonText}>Analyze Compliance</Text>
      </TouchableOpacity>

      <View style={styles.infoBox}>
        <CheckCircle color="#007b55" size={20} style={{ marginRight: 8 }} />
        <Text style={styles.infoText}>Using local model: Syria-Regulatory-Llama-v2.1</Text>
      </View>
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#f9fafb',
    padding: 16,
  },
  pageTitle: {
    fontSize: 24,
    fontWeight: 'bold',
    color: '#212b36',
    marginBottom: 4,
  },
  pageSubtitle: {
    fontSize: 16,
    color: '#637381',
    marginBottom: 24,
  },
  inputContainer: {
    backgroundColor: '#ffffff',
    borderRadius: 12,
    borderWidth: 1,
    borderColor: '#e5e8eb',
    marginBottom: 24,
    overflow: 'hidden',
  },
  textInput: {
    height: 150,
    padding: 16,
    fontSize: 16,
    color: '#212b36',
    textAlignVertical: 'top',
  },
  actionRow: {
    flexDirection: 'row',
    borderTopWidth: 1,
    borderTopColor: '#e5e8eb',
    padding: 8,
    backgroundColor: '#f4f6f8',
  },
  iconButton: {
    flexDirection: 'row',
    alignItems: 'center',
    padding: 8,
    marginRight: 16,
  },
  iconButtonText: {
    marginLeft: 6,
    fontSize: 14,
    color: '#637381',
    fontWeight: '500',
  },
  analyzeButton: {
    backgroundColor: '#007b55',
    borderRadius: 8,
    flexDirection: 'row',
    justifyContent: 'center',
    alignItems: 'center',
    paddingVertical: 14,
    marginBottom: 24,
  },
  analyzeButtonText: {
    color: '#ffffff',
    fontSize: 16,
    fontWeight: 'bold',
  },
  infoBox: {
    flexDirection: 'row',
    backgroundColor: '#e1f5ed',
    padding: 12,
    borderRadius: 8,
    alignItems: 'center',
  },
  infoText: {
    color: '#004b36',
    fontSize: 14,
  },
  // Results view styles
  resultHeader: {
    marginBottom: 20,
  },
  moleculeTitle: {
    fontSize: 24,
    fontWeight: 'bold',
    color: '#212b36',
  },
  dosageForm: {
    fontSize: 16,
    color: '#637381',
    marginTop: 4,
  },
  scoreContainer: {
    backgroundColor: '#ffffff',
    borderRadius: 12,
    padding: 24,
    alignItems: 'center',
    marginBottom: 24,
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.05,
    shadowRadius: 4,
    elevation: 2,
  },
  scoreLabel: {
    fontSize: 16,
    color: '#637381',
    marginBottom: 12,
  },
  scoreCircle: {
    width: 100,
    height: 100,
    borderRadius: 50,
    borderWidth: 8,
    borderColor: '#ff4842',
    justifyContent: 'center',
    alignItems: 'center',
    marginBottom: 12,
  },
  scoreValue: {
    fontSize: 32,
    fontWeight: 'bold',
    color: '#212b36',
  },
  statusLabel: {
    fontSize: 18,
    fontWeight: 'bold',
    color: '#ff4842',
  },
  sectionTitle: {
    fontSize: 18,
    fontWeight: 'bold',
    color: '#212b36',
    marginBottom: 16,
    marginTop: 8,
  },
  flagCard: {
    backgroundColor: '#ffffff',
    borderRadius: 8,
    padding: 16,
    marginBottom: 12,
    borderLeftWidth: 4,
    borderLeftColor: '#ff4842',
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 1 },
    shadowOpacity: 0.05,
    shadowRadius: 2,
    elevation: 1,
  },
  flagHeader: {
    flexDirection: 'row',
    alignItems: 'center',
    marginBottom: 8,
  },
  flagTitle: {
    fontSize: 16,
    fontWeight: 'bold',
    color: '#212b36',
    marginLeft: 8,
  },
  flagDescription: {
    fontSize: 14,
    color: '#637381',
    lineHeight: 20,
  },
  reqCard: {
    flexDirection: 'row',
    backgroundColor: '#ffffff',
    borderRadius: 8,
    padding: 16,
    marginBottom: 8,
    alignItems: 'center',
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 1 },
    shadowOpacity: 0.05,
    shadowRadius: 2,
    elevation: 1,
  },
  reqCheckbox: {
    width: 20,
    height: 20,
    borderRadius: 4,
    borderWidth: 2,
    borderColor: '#c4cdd5',
    marginRight: 12,
  },
  reqTitle: {
    fontSize: 15,
    color: '#212b36',
  },
  resetButton: {
    backgroundColor: '#f4f6f8',
    borderRadius: 8,
    paddingVertical: 14,
    alignItems: 'center',
    marginTop: 24,
    marginBottom: 40,
  },
  resetButtonText: {
    color: '#212b36',
    fontSize: 16,
    fontWeight: 'bold',
  },
});
