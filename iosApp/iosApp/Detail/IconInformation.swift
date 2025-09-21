//
//  IconInformation.swift
//  iosApp
//
//  Created by Jorge Gimeno Latas on 21/9/25.
//

import SwiftUI

struct IconInformation: View {

    let text: String
    let Icon: Image
    
    var body: some View {
        VStack{
            Icon
                .resizable()
                .frame(width: 50,height: 50)
            Text(text)
        }
    }
}

#Preview {
    IconInformation(text: "PEPITO",Icon: Image("strong"))
}
