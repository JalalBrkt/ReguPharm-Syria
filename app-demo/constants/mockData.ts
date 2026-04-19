export const MOCK_ANALYSIS_RESULT = {
  molecule: "Dexlansoprazole",
  dosage: "60mg",
  form: "Modified Release Capsule",
  status: "Non-Compliant",
  score: 68,
  flags: [
    {
      id: "1",
      title: "Missing BE Study for 60mg",
      description: "Local guidelines require Bioequivalence studies specifically for the highest strength (60mg). Current dossier only includes BE for 30mg.",
      severity: "critical"
    },
    {
      id: "2",
      title: "Stability Data Gap",
      description: "Zone IVb stability data shows 6 months. Minimum 12 months required for generic registration.",
      severity: "high"
    },
    {
      id: "3",
      title: "API Manufacturer DMF",
      description: "Drug Master File (DMF) version is v4.1, but regulatory authority requires minimum v4.2 for new submissions.",
      severity: "medium"
    }
  ],
  requirements: [
    {
      id: "req1",
      title: "Submit 60mg BE Study",
      status: "pending"
    },
    {
      id: "req2",
      title: "Provide 12M Zone IVb Stability",
      status: "pending"
    },
    {
      id: "req3",
      title: "Update API DMF to v4.2+",
      status: "pending"
    }
  ]
};

export const MOCK_GUIDES = [
  {
    id: "g1",
    title: "Syrian MOH Registration Guidelines 2023",
    size: "4.2 MB",
    type: "PDF",
    date: "Oct 2023",
    category: "Regulatory",
    icon: "book"
  },
  {
    id: "g2",
    title: "Bioequivalence Requirements v2.1",
    size: "1.8 MB",
    type: "PDF",
    date: "Aug 2023",
    category: "Clinical",
    icon: "file-text"
  },
  {
    id: "g3",
    title: "Stability Zones & Local Requirements",
    size: "2.5 MB",
    type: "PDF",
    date: "Jan 2023",
    category: "Quality",
    icon: "thermometer"
  },
  {
    id: "g4",
    title: "Pricing Calculation Matrix (Updated)",
    size: "850 KB",
    type: "Excel",
    date: "Nov 2023",
    category: "Commercial",
    icon: "table"
  }
];

export const MOCK_VAULT_FILES = [
  {
    id: "v1",
    name: "Pending Submissions",
    type: "folder",
    count: 12,
    date: "Today, 10:45 AM"
  },
  {
    id: "v2",
    name: "Approved Dossiers",
    type: "folder",
    count: 145,
    date: "Yesterday"
  },
  {
    id: "v3",
    name: "Deficiency Letters",
    type: "folder",
    count: 3,
    date: "Oct 24, 2023"
  },
  {
    id: "v4",
    name: "Dexlansoprazole_60mg_Draft.pdf",
    type: "file",
    size: "18.5 MB",
    date: "2 mins ago"
  },
  {
    id: "v5",
    name: "Stability_Data_Summary.xlsx",
    type: "file",
    size: "2.1 MB",
    date: "1 hour ago"
  }
];

export const MOCK_MODELS = {
  active: {
    id: "m1",
    name: "Syria-Regulatory-Llama-v2.1",
    description: "Highly optimized large language model tailored for Syrian pharmaceutical regulations, dossier analysis, and compliance checking. Operating entirely on-device for maximum data privacy.",
    version: "v2.1.0-stable",
    lastUpdated: "Oct 24, 2023",
    size: "4.2 GB",
    status: "Active"
  },
  available: [
    {
      id: "m2",
      name: "Lightweight Triage Model",
      description: "Fast inference for basic queries...",
      status: "Ready",
      size: "1.8 GB"
    },
    {
      id: "m3",
      name: "Comprehensive Dossier Scanner",
      description: "Deep analysis for extensive...",
      status: "Ready",
      size: "8.5 GB"
    }
  ],
  cloud: [
    {
      id: "c1",
      name: "Knowledge Base Update: Syrian Pharma Codex Q4 Addendum",
      description: "Includes updated pricing structures and import regulations for biologicals.",
      size: "145 MB",
      type: "Update",
      tag: "NEW"
    },
    {
      id: "c2",
      name: "Model Weights: Syria-Regulatory-Llama v2.2 Delta",
      description: "Improved accuracy for adverse event reporting classification.",
      size: "850 MB",
      type: "Model"
    }
  ]
};
