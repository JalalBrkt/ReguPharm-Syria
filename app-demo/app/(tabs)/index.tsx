import { StyleSheet, ScrollView, View, Text } from 'react-native';
import { Activity, Clock, ShieldCheck, AlertCircle } from 'lucide-react-native';

export default function DashboardScreen() {
  return (
    <ScrollView style={styles.container}>
      <View style={styles.header}>
        <Text style={styles.title}>Welcome back, Analyst</Text>
        <Text style={styles.subtitle}>System Status: Online</Text>
      </View>

      <View style={styles.metricsContainer}>
        <View style={styles.metricCard}>
          <Activity color="#007b55" size={32} />
          <Text style={styles.metricValue}>24</Text>
          <Text style={styles.metricLabel}>Analyses Today</Text>
        </View>
        <View style={styles.metricCard}>
          <ShieldCheck color="#2e8540" size={32} />
          <Text style={styles.metricValue}>12</Text>
          <Text style={styles.metricLabel}>Compliant</Text>
        </View>
        <View style={styles.metricCard}>
          <AlertCircle color="#ff4842" size={32} />
          <Text style={styles.metricValue}>8</Text>
          <Text style={styles.metricLabel}>Critical Flags</Text>
        </View>
        <View style={styles.metricCard}>
          <Clock color="#ffa48d" size={32} />
          <Text style={styles.metricValue}>4</Text>
          <Text style={styles.metricLabel}>Pending Review</Text>
        </View>
      </View>

      <View style={styles.section}>
        <Text style={styles.sectionTitle}>Recent Activity</Text>
        <View style={styles.activityItem}>
          <Text style={styles.activityText}>Dexlansoprazole 60mg - Analysis Completed</Text>
          <Text style={styles.activityTime}>2 mins ago</Text>
        </View>
        <View style={styles.activityItem}>
          <Text style={styles.activityText}>Stability Data Summary.xlsx - Uploaded</Text>
          <Text style={styles.activityTime}>1 hour ago</Text>
        </View>
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
  header: {
    marginBottom: 24,
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
    color: '#212b36',
  },
  subtitle: {
    fontSize: 16,
    color: '#637381',
    marginTop: 4,
  },
  metricsContainer: {
    flexDirection: 'row',
    flexWrap: 'wrap',
    justifyContent: 'space-between',
  },
  metricCard: {
    backgroundColor: '#ffffff',
    width: '48%',
    padding: 16,
    borderRadius: 12,
    marginBottom: 16,
    alignItems: 'center',
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.05,
    shadowRadius: 4,
    elevation: 2,
  },
  metricValue: {
    fontSize: 28,
    fontWeight: 'bold',
    color: '#212b36',
    marginTop: 8,
  },
  metricLabel: {
    fontSize: 14,
    color: '#637381',
    marginTop: 4,
  },
  section: {
    marginTop: 16,
  },
  sectionTitle: {
    fontSize: 18,
    fontWeight: 'bold',
    color: '#212b36',
    marginBottom: 12,
  },
  activityItem: {
    backgroundColor: '#ffffff',
    padding: 16,
    borderRadius: 8,
    marginBottom: 8,
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 1 },
    shadowOpacity: 0.05,
    shadowRadius: 2,
    elevation: 1,
  },
  activityText: {
    fontSize: 14,
    color: '#212b36',
  },
  activityTime: {
    fontSize: 12,
    color: '#919eab',
    marginTop: 4,
  },
});
