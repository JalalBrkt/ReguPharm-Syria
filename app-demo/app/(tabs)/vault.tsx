import { StyleSheet, ScrollView, View, Text, TouchableOpacity, TextInput } from 'react-native';
import { Folder, FileText, Search, Filter, Plus, FileSpreadsheet } from 'lucide-react-native';
import { MOCK_VAULT_FILES } from '@/constants/mockData';

export default function VaultScreen() {
  return (
    <View style={styles.container}>
      <View style={styles.header}>
        <Text style={styles.title}>Local Dossier Vault</Text>
        <Text style={styles.subtitle}>Secure on-device storage</Text>
      </View>

      <View style={styles.searchContainer}>
        <View style={styles.searchBar}>
          <Search color="#919eab" size={20} style={styles.searchIcon} />
          <TextInput
            style={styles.searchInput}
            placeholder="Search dossiers, active ingredients..."
            placeholderTextColor="#919eab"
          />
        </View>
        <TouchableOpacity style={styles.filterButton}>
          <Filter color="#212b36" size={20} />
        </TouchableOpacity>
      </View>

      <ScrollView style={styles.scrollView} showsVerticalScrollIndicator={false}>
        <Text style={styles.sectionTitle}>Folders</Text>
        <View style={styles.gridContainer}>
          {MOCK_VAULT_FILES.filter(item => item.type === 'folder').map(folder => (
            <TouchableOpacity key={folder.id} style={styles.folderCard}>
              <Folder color="#007b55" size={32} style={styles.folderIcon} />
              <Text style={styles.folderName} numberOfLines={1}>{folder.name}</Text>
              <Text style={styles.folderCount}>{folder.count} items</Text>
            </TouchableOpacity>
          ))}
        </View>

        <Text style={styles.sectionTitle}>Recent Files</Text>
        {MOCK_VAULT_FILES.filter(item => item.type === 'file').map(file => (
          <TouchableOpacity key={file.id} style={styles.fileRow}>
            <View style={styles.fileIconContainer}>
              {file.name.endsWith('.xlsx') ? (
                <FileSpreadsheet color="#007b55" size={24} />
              ) : (
                <FileText color="#007b55" size={24} />
              )}
            </View>
            <View style={styles.fileDetails}>
              <Text style={styles.fileName} numberOfLines={1}>{file.name}</Text>
              <View style={styles.fileMetaRow}>
                <Text style={styles.fileMeta}>{file.size}</Text>
                <Text style={styles.fileMetaDot}>•</Text>
                <Text style={styles.fileMeta}>{file.date}</Text>
              </View>
            </View>
          </TouchableOpacity>
        ))}
        <View style={{ height: 40 }} />
      </ScrollView>

      <TouchableOpacity style={styles.fab}>
        <Plus color="#ffffff" size={24} />
      </TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#f9fafb',
  },
  header: {
    padding: 16,
    paddingBottom: 8,
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
    color: '#212b36',
  },
  subtitle: {
    fontSize: 14,
    color: '#637381',
    marginTop: 4,
  },
  searchContainer: {
    flexDirection: 'row',
    padding: 16,
    paddingTop: 8,
  },
  searchBar: {
    flex: 1,
    flexDirection: 'row',
    alignItems: 'center',
    backgroundColor: '#ffffff',
    borderRadius: 8,
    borderWidth: 1,
    borderColor: '#e5e8eb',
    marginRight: 12,
  },
  searchIcon: {
    marginLeft: 12,
    marginRight: 8,
  },
  searchInput: {
    flex: 1,
    height: 48,
    fontSize: 16,
    color: '#212b36',
  },
  filterButton: {
    width: 48,
    height: 48,
    backgroundColor: '#ffffff',
    borderRadius: 8,
    borderWidth: 1,
    borderColor: '#e5e8eb',
    justifyContent: 'center',
    alignItems: 'center',
  },
  scrollView: {
    paddingHorizontal: 16,
  },
  sectionTitle: {
    fontSize: 18,
    fontWeight: 'bold',
    color: '#212b36',
    marginTop: 16,
    marginBottom: 12,
  },
  gridContainer: {
    flexDirection: 'row',
    flexWrap: 'wrap',
    justifyContent: 'space-between',
  },
  folderCard: {
    width: '48%',
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
  folderIcon: {
    marginBottom: 12,
  },
  folderName: {
    fontSize: 15,
    fontWeight: '600',
    color: '#212b36',
    marginBottom: 4,
  },
  folderCount: {
    fontSize: 13,
    color: '#637381',
  },
  fileRow: {
    flexDirection: 'row',
    backgroundColor: '#ffffff',
    borderRadius: 12,
    padding: 16,
    marginBottom: 8,
    alignItems: 'center',
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 1 },
    shadowOpacity: 0.05,
    shadowRadius: 2,
    elevation: 1,
  },
  fileIconContainer: {
    width: 40,
    height: 40,
    borderRadius: 8,
    backgroundColor: '#f4f6f8',
    justifyContent: 'center',
    alignItems: 'center',
    marginRight: 16,
  },
  fileDetails: {
    flex: 1,
  },
  fileName: {
    fontSize: 15,
    fontWeight: '500',
    color: '#212b36',
    marginBottom: 4,
  },
  fileMetaRow: {
    flexDirection: 'row',
    alignItems: 'center',
  },
  fileMeta: {
    fontSize: 13,
    color: '#637381',
  },
  fileMetaDot: {
    fontSize: 13,
    color: '#637381',
    marginHorizontal: 6,
  },
  fab: {
    position: 'absolute',
    bottom: 24,
    right: 24,
    width: 56,
    height: 56,
    borderRadius: 28,
    backgroundColor: '#007b55',
    justifyContent: 'center',
    alignItems: 'center',
    shadowColor: '#007b55',
    shadowOffset: { width: 0, height: 4 },
    shadowOpacity: 0.3,
    shadowRadius: 8,
    elevation: 6,
  },
});
