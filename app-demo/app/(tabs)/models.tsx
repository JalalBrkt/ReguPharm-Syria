import { StyleSheet, ScrollView, View, Text, TouchableOpacity } from 'react-native';
import { Cpu, Gauge, FileSearch, Cloud, Download, RefreshCw, CheckCircle } from 'lucide-react-native';
import { MOCK_MODELS } from '@/constants/mockData';

export default function ModelsScreen() {
  return (
    <ScrollView style={styles.container} showsVerticalScrollIndicator={false}>
      <View style={styles.header}>
        <Text style={styles.title}>Active Model Environment</Text>
      </View>

      <View style={styles.activeCard}>
        <View style={styles.activeHeader}>
          <Cpu color="#007b55" size={24} style={styles.activeIcon} />
          <Text style={styles.activeTitle}>{MOCK_MODELS.active.name}</Text>
        </View>
        <Text style={styles.activeDescription}>{MOCK_MODELS.active.description}</Text>

        <View style={styles.metaGrid}>
          <View style={styles.metaItem}>
            <Text style={styles.metaLabel}>VERSION</Text>
            <Text style={styles.metaValue}>{MOCK_MODELS.active.version}</Text>
          </View>
          <View style={styles.metaItem}>
            <Text style={styles.metaLabel}>LAST UPDATED</Text>
            <Text style={styles.metaValue}>{MOCK_MODELS.active.lastUpdated}</Text>
          </View>
          <View style={styles.metaItem}>
            <Text style={styles.metaLabel}>SIZE</Text>
            <Text style={styles.metaValue}>{MOCK_MODELS.active.size}</Text>
          </View>
        </View>

        <TouchableOpacity style={styles.updateButton}>
          <RefreshCw color="#ffffff" size={18} style={styles.updateIcon} />
          <Text style={styles.updateButtonText}>Check for Updates</Text>
        </TouchableOpacity>
      </View>

      <View style={styles.sectionHeader}>
        <Text style={styles.sectionTitle}>Available Local Models</Text>
        <Text style={styles.sectionBadge}>{MOCK_MODELS.available.length} Downloaded</Text>
      </View>

      {MOCK_MODELS.available.map((model, index) => (
        <View key={model.id} style={styles.modelCard}>
          <View style={styles.modelHeader}>
            <View style={styles.modelIconContainer}>
              {index === 0 ? <Gauge color="#212b36" size={20} /> : <FileSearch color="#212b36" size={20} />}
            </View>
            <View style={styles.modelInfo}>
              <Text style={styles.modelName}>{model.name}</Text>
              <Text style={styles.modelDesc}>{model.description}</Text>
              <View style={styles.modelStatusRow}>
                <CheckCircle color="#007b55" size={14} />
                <Text style={styles.statusText}>{model.status}</Text>
                <Text style={styles.sizeText}>{model.size}</Text>
              </View>
            </View>
          </View>
          <TouchableOpacity style={styles.selectButton}>
            <Text style={styles.selectButtonText}>Select Model</Text>
          </TouchableOpacity>
        </View>
      ))}

      <View style={styles.sectionHeader}>
        <Text style={styles.sectionTitle}>Cloud Repository</Text>
        <Cloud color="#212b36" size={24} />
      </View>

      <View style={styles.cloudContainer}>
        {MOCK_MODELS.cloud.map((item, index) => (
          <View key={item.id} style={[styles.cloudCard, index === 0 ? styles.cloudCardNew : null]}>
            <View style={styles.cloudCardInner}>
              <View style={styles.cloudHeaderRow}>
                <Text style={styles.cloudType}>{item.type === 'Update' ? 'KNOWLEDGE BASE UPDATE' : 'MODEL WEIGHTS'}</Text>
                {item.tag && (
                  <View style={styles.tagBadge}>
                    <Text style={styles.tagText}>{item.tag}</Text>
                  </View>
                )}
              </View>
              <Text style={styles.cloudTitle}>{item.name.replace('Knowledge Base Update: ', '').replace('Model Weights: ', '')}</Text>
              <Text style={styles.cloudDesc}>{item.description}</Text>

              <View style={styles.cloudFooter}>
                <Text style={styles.cloudSize}>{item.size}</Text>
                <TouchableOpacity style={styles.downloadAction}>
                  <Text style={styles.downloadText}>Download</Text>
                  <Download color="#212b36" size={16} />
                </TouchableOpacity>
              </View>
            </View>
          </View>
        ))}
      </View>

      <View style={{ height: 40 }} />
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#f9fafb',
    padding: 16,
  },
  header: {
    marginBottom: 20,
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
    color: '#212b36',
  },
  activeCard: {
    backgroundColor: '#ffffff',
    borderRadius: 16,
    padding: 20,
    marginBottom: 32,
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.05,
    shadowRadius: 8,
    elevation: 3,
  },
  activeHeader: {
    flexDirection: 'row',
    alignItems: 'center',
    marginBottom: 16,
  },
  activeIcon: {
    marginRight: 12,
  },
  activeTitle: {
    fontSize: 20,
    fontWeight: 'bold',
    color: '#212b36',
    flex: 1,
  },
  activeDescription: {
    fontSize: 15,
    color: '#637381',
    lineHeight: 22,
    marginBottom: 20,
  },
  metaGrid: {
    flexDirection: 'row',
    flexWrap: 'wrap',
    marginBottom: 24,
  },
  metaItem: {
    width: '50%',
    marginBottom: 16,
  },
  metaLabel: {
    fontSize: 12,
    fontWeight: '600',
    color: '#919eab',
    marginBottom: 4,
    letterSpacing: 0.5,
  },
  metaValue: {
    fontSize: 15,
    color: '#212b36',
    fontWeight: '500',
  },
  updateButton: {
    backgroundColor: '#161c24',
    borderRadius: 8,
    flexDirection: 'row',
    justifyContent: 'center',
    alignItems: 'center',
    paddingVertical: 14,
  },
  updateIcon: {
    marginRight: 8,
  },
  updateButtonText: {
    color: '#ffffff',
    fontSize: 15,
    fontWeight: 'bold',
  },
  sectionHeader: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
    marginBottom: 16,
  },
  sectionTitle: {
    fontSize: 18,
    fontWeight: 'bold',
    color: '#212b36',
  },
  sectionBadge: {
    backgroundColor: '#f4f6f8',
    paddingHorizontal: 12,
    paddingVertical: 4,
    borderRadius: 12,
    fontSize: 13,
    color: '#637381',
    fontWeight: '500',
  },
  modelCard: {
    backgroundColor: '#ffffff',
    borderRadius: 12,
    padding: 16,
    marginBottom: 16,
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 1 },
    shadowOpacity: 0.05,
    shadowRadius: 2,
    elevation: 1,
  },
  modelHeader: {
    flexDirection: 'row',
    marginBottom: 16,
  },
  modelIconContainer: {
    width: 40,
    height: 40,
    borderRadius: 8,
    backgroundColor: '#e5e8eb',
    justifyContent: 'center',
    alignItems: 'center',
    marginRight: 16,
  },
  modelInfo: {
    flex: 1,
  },
  modelName: {
    fontSize: 16,
    fontWeight: 'bold',
    color: '#212b36',
    marginBottom: 4,
  },
  modelDesc: {
    fontSize: 14,
    color: '#637381',
    marginBottom: 8,
  },
  modelStatusRow: {
    flexDirection: 'row',
    alignItems: 'center',
  },
  statusText: {
    fontSize: 13,
    color: '#007b55',
    fontWeight: '600',
    marginLeft: 6,
    marginRight: 12,
  },
  sizeText: {
    fontSize: 13,
    color: '#919eab',
  },
  selectButton: {
    borderWidth: 1,
    borderColor: '#c4cdd5',
    borderRadius: 8,
    paddingVertical: 10,
    alignItems: 'center',
  },
  selectButtonText: {
    color: '#212b36',
    fontSize: 14,
    fontWeight: '600',
  },
  cloudContainer: {
    backgroundColor: '#f4f6f8',
    borderRadius: 16,
    padding: 16,
    marginBottom: 16,
  },
  cloudCard: {
    backgroundColor: '#ffffff',
    borderRadius: 12,
    marginBottom: 12,
    overflow: 'hidden',
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 1 },
    shadowOpacity: 0.05,
    shadowRadius: 2,
    elevation: 1,
  },
  cloudCardNew: {
    borderLeftWidth: 4,
    borderLeftColor: '#ffa48d',
  },
  cloudCardInner: {
    padding: 16,
  },
  cloudHeaderRow: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    marginBottom: 8,
  },
  cloudType: {
    fontSize: 11,
    fontWeight: 'bold',
    color: '#637381',
    letterSpacing: 0.5,
  },
  tagBadge: {
    backgroundColor: '#ffe4de',
    paddingHorizontal: 8,
    paddingVertical: 2,
    borderRadius: 4,
  },
  tagText: {
    fontSize: 10,
    fontWeight: 'bold',
    color: '#b72136',
  },
  cloudTitle: {
    fontSize: 15,
    fontWeight: 'bold',
    color: '#212b36',
    marginBottom: 8,
  },
  cloudDesc: {
    fontSize: 14,
    color: '#637381',
    lineHeight: 20,
    marginBottom: 16,
  },
  cloudFooter: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
  },
  cloudSize: {
    fontSize: 13,
    color: '#637381',
  },
  downloadAction: {
    flexDirection: 'row',
    alignItems: 'center',
  },
  downloadText: {
    fontSize: 14,
    fontWeight: '600',
    color: '#212b36',
    marginRight: 6,
  },
});
