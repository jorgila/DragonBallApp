//
//  LabelInformation.swift
//  iosApp
//
//  Created by Jorge Gimeno Latas on 21/9/25.
//

import SwiftUI

struct LabelInformation: View {
    
    let text: String
    
    var body: some View {
        Text(text)
            .padding(.horizontal,20)
            .padding(.vertical,8)
            .overlay(RoundedRectangle(cornerRadius: 20).stroke(Color(.backgroundPrimary),lineWidth: 3))
    }
}

#Preview {
    LabelInformation(text: "PEPITO")
}
