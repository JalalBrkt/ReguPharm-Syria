import { StyleSheet, ScrollView, View, Text, TouchableOpacity, TextInput } from 'react-native';
import { Search, Book, FileText, Thermometer, Table, Download } from 'lucide-react-native';
import { MOCK_GUIDES } from '@/constants/mockData';

export default function GuideScreen() {
  const getIcon = (iconName: string) => {
    switch (iconName) {
      case 'book': return <Book color="#007b55" size={24} />;
      case 'file-text': return <FileText color="#007b55" size={24} />;
      case 'thermometer': return <Thermometer color="#007b55" size={24} />;
      case 'table': return <Table color="#007b55" size={24} />;
      default: return <FileText color="#007b55" size={24} />;
    }
  };

  return (
    <View style={styles.container}>
      <View style={styles.header}>
        <Text style={styles.title}>Reference Guides</Text>
        <Text style={styles.subtitle}>Syrian MOH Guidelines & Protocols</Text>
      </View>

      <View style={styles.searchContainer}>
        <View style={styles.searchBar}>
          <Search color="#919eab" size={20} style={styles.searchIcon} />
          <TextInput
            style={styles.searchInput}
            placeholder="Search guidelines..."
            placeholderTextColor="#919eab"
          />
        </View>
      </View>

      <View style={styles.categoriesContainer}>
        <ScrollView horizontal showsHorizontalScrollIndicator={false} contentContainerStyle={styles.categoriesScroll}>
          <TouchableOpacity style={[styles.categoryPill, styles.categoryPillActive]}>
            <Text style={[styles.categoryText, styles.categoryTextActive]}>All</Text>
          </TouchableOpacity>
          <TouchableOpacity style={styles.categoryPill}>
            <Text style={styles.categoryText}>Regulatory</Text>
          </TouchableOpacity>
          <TouchableOpacity style={styles.categoryPill}>
            <Text style={styles.categoryText}>Clinical</Text>
          </TouchableOpacity>
          <TouchableOpacity style={styles.categoryPill}>
            <Text style={styles.categoryText}>Quality</Text>
          </TouchableOpacity>
        </ScrollView>
      </View>

      <ScrollView style={styles.scrollView} showsVerticalScrollIndicator={false}>
        {MOCK_GUIDES.map((guide) => (
          <TouchableOpacity key={guide.id} style={styles.guideCard}>
            <View style={styles.iconContainer}>
              {getIcon(guide.icon)}
            </View>
            <View style={styles.guideDetails}>
              <Text style={styles.guideTitle} numberOfLines={2}>{guide.title}</Text>
              <View style={styles.guideMetaRow}>
                <Text style={styles.guideTag}>{guide.category}</Text>
                <Text style={styles.guideMetaDot}>•</Text>
                <Text style={styles.guideMeta}>{guide.size}</Text>
                <Text style={styles.guideMetaDot}>•</Text>
                <Text style={styles.guideMeta}>{guide.date}</Text>
              </View>
            </View>
            <TouchableOpacity style={styles.downloadButton}>
              <Download color="#007b55" size={20} />
            </TouchableOpacity>
          </TouchableOpacity>
        ))}
        <View style={{ height: 40 }} />
      </ScrollView>
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
    padding: 16,
    paddingTop: 8,
    paddingBottom: 8,
  },
  searchBar: {
    flexDirection: 'row',
    alignItems: 'center',
    backgroundColor: '#ffffff',
    borderRadius: 8,
    borderWidth: 1,
    borderColor: '#e5e8eb',
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
  categoriesContainer: {
    marginBottom: 12,
  },
  categoriesScroll: {
    paddingHorizontal: 16,
    paddingVertical: 4,
  },
  categoryPill: {
    paddingHorizontal: 16,
    paddingVertical: 8,
    borderRadius: 20,
    backgroundColor: '#ffffff',
    borderWidth: 1,
    borderColor: '#e5e8eb',
    marginRight: 8,
  },
  categoryPillActive: {
    backgroundColor: '#007b55',
    borderColor: '#007b55',
  },
  categoryText: {
    fontSize: 14,
    color: '#637381',
    fontWeight: '500',
  },
  categoryTextActive: {
    color: '#ffffff',
  },
  scrollView: {
    paddingHorizontal: 16,
  },
  guideCard: {
    flexDirection: 'row',
    backgroundColor: '#ffffff',
    borderRadius: 12,
    padding: 16,
    marginBottom: 12,
    alignItems: 'center',
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 1 },
    shadowOpacity: 0.05,
    shadowRadius: 2,
    elevation: 1,
  },
  iconContainer: {
    width: 48,
    height: 48,
    borderRadius: 12,
    backgroundColor: '#f4f6f8',
    justifyContent: 'center',
    alignItems: 'center',
    marginRight: 16,
  },
  guideDetails: {
    flex: 1,
  },
  guideTitle: {
    fontSize: 16,
    fontWeight: '600',
    color: '#212b36',
    marginBottom: 6,
  },
  guideMetaRow: {
    flexDirection: 'row',
    alignItems: 'center',
    flexWrap: 'wrap',
  },
  guideTag: {
    fontSize: 12,
    fontWeight: '500',
    color: '#007b55',
    backgroundColor: '#e1f5ed',
    paddingHorizontal: 8,
    paddingVertical: 2,
    borderRadius: 4,
  },
  guideMeta: {
    fontSize: 13,
    color: '#637381',
  },
  guideMetaDot: {
    fontSize: 13,
    color: '#c4cdd5',
    marginHorizontal: 6,
  },
  downloadButton: {
    padding: 8,
  },
});
